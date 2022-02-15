package com.wpf.generator;

import com.wpf.mapper.GeneratorMapper;
import com.wpf.model.GenIndicator;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @AUTHOR: wangpf2
 * @DATETIME: 2022/02/14 10:22:59
 * @DESCRIPTION:
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private GeneratorMapper generatorMapper;

    @Override
    public String export(List<Map<String, Object>> list) {

        String templatePath = "src/main/java/com/wpf/template";
        String exportPath = "C:\\Users\\羽\\Desktop\\generator-action";
        //创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            //获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            //遍历构建数据模型
            for (Map<String, Object> dataMap : list) {
                // 加载模版文件
                Template template = configuration.getTemplate("generator.ftl");
                // 生成数据文件流
                File docFile = new File(exportPath + "\\" + dataMap.get("indicatorClassName") + ".java");
                if(!docFile.getParentFile().exists()){
                    docFile.getParentFile().mkdirs();
                }
                if(!docFile.exists()){
                    docFile.createNewFile();
                }
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
                // 输出文件
                dataMap.put("currentTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
                template.process(dataMap, out);
                System.out.println(dataMap.get("indicatorClassName") + ".java 文件创建成功 !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "success";
    }

    @Override
    public String create() {
        try {
            generatorMapper.createTable();
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public String insert(GenIndicator genIndicator) {
        try {
            generatorMapper.insert(genIndicator);
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @Override
    public List<GenIndicator> select() {
        try {
            List<GenIndicator> list = generatorMapper.select();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String truncate() {
        try {
            generatorMapper.truncate();
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
