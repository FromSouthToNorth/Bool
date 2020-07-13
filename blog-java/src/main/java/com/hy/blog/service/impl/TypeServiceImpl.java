package com.hy.blog.service.impl;

import com.hy.blog.dao.TypeDAO;
import com.hy.blog.entity.Type;
import com.hy.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDAO typeDAO;

    @Override
    public List<Type> findBlogType() {
        return typeDAO.findBlogType();
    }

    @Override
    public Type findByTypeId(Long typeId) {
        return typeDAO.findByTypeId(typeId);
    }

}
