package com.hy.blog.service.adminService;

import com.hy.blog.entity.Type;

import java.util.List;

public interface AdminTypeService {

    Integer saveType(String name);

    Integer deleteByIdType(Long id);

    Integer updateByIdType(Type type);

    Type findByIdType(Long id);

    Type findByNameType(String name);

    List<Type> findAllType();

}
