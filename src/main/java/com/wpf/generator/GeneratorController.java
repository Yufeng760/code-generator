package com.wpf.generator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wpf.mapper.GeneratorMapper;
import com.wpf.model.GenIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * @AUTHOR: wangpf2
 * @DATETIME: 2022/02/14 10:26:24
 * @DESCRIPTION:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/generator/")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @PostMapping(value = "export")
    public String export(@RequestBody List<Map<String, Object>> list) {
        return generatorService.export(list);
    }

    @RequestMapping(value = "create")
    public String create() {
        return generatorService.create();
    }

    @RequestMapping(value = "insert")
    public String insert(@RequestBody GenIndicator genIndicator) {
        return generatorService.insert(genIndicator);
    }

    @RequestMapping(value = "select")
    public List<GenIndicator> select() {
        return generatorService.select();
    }

    @RequestMapping(value = "truncate")
    public String truncate() {
        return generatorService.truncate();
    }

}
