package com.hy.blog.dao;

import com.hy.blog.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeDAO {

    List<Type> findBlogType();

    Type findByTypeId(@Param("typeId") Long typeId);

}
