package com.wpf.generator;

import com.wpf.model.GenIndicator;

import java.util.List;
import java.util.Map;

/*
 * @AUTHOR: wangpf2
 * @DATETIME: 2022/02/14 09:49:21
 * @DESCRIPTION: 代码生成服务
 */
public interface GeneratorService {

    String export(List<Map<String,Object>> list);

    String create();

    String insert(GenIndicator genIndicator);

    List<GenIndicator> select();

    String truncate();
}
