package com.wpf.mapper;

import com.wpf.model.GenIndicator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/*
 * @AUTHOR: wangpf2
 * @DATETIME: 2022/02/14 14:13:23
 * @DESCRIPTION:
 */
@Mapper
public interface GeneratorMapper {

    void createTable();

    int insert(GenIndicator genIndicator);

    List<GenIndicator> select();

    void truncate();
}
