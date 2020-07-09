package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AdminTypeDAO {

    Integer saveType(@Param("name") String name);

    Integer deleteByIdType(@Param("id") Long id);

    Integer updateByIdType(Type type);

    Type findByIdType(@Param("id") Long id);

    Type findByNameType(@Param("name") String name);

    List<Type> findAllType();

}
