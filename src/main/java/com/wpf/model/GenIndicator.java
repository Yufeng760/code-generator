package com.wpf.model;

import lombok.Data;

/*
 * @AUTHOR: wangpf2
 * @DATETIME: 2022/02/14 14:15:59
 * @DESCRIPTION:
 */
@Data
public class GenIndicator {


    /**
     * 主键
     */
    private Integer id;
    /**
     * 包路径
     */
    private String packageName;
    /**
     * 指标名称
     */
    private String indicatorName;
    /**
     * 指标处理类名
     */
    private String indicatorClassName;
    /**
     * 指标对应的配置类
     */
    private String indicatorConfigClassName;
    /**
     * 导出excel的模板对象名称
     */
    private String exportExcelClassName;

}
