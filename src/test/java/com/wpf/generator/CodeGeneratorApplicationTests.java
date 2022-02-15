package com.wpf.generator;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

class CodeGeneratorApplicationTests {

    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("classPath", "com.wpf.code");
        dataMap.put("indictorName", "超期无理由未发放案款");
        dataMap.put("indicatorClassName", "CqwffakAction");
        dataMap.put("indicatorConfigClass", "CQWLYWFFAK");
        dataMap.put("exportExcelClassName", "CqwlywffakExcel");
        System.out.println(JSON.toJSONString(dataMap));
    }

}
