package com.hy.blog.dao;

import com.hy.blog.entity.Type;
import com.hy.blog.vo.DataStringValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeDAO {

    List<Type> findBlogType();

    Type findByTypeId(@Param("typeId") Long typeId);

    List<DataStringValue> findHomeType();

    List<DataStringValue> findAllType();

}
