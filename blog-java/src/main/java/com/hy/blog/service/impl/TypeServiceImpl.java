package com.hy.blog.service.impl;

import com.hy.blog.dao.TypeDAO;
import com.hy.blog.entity.Type;
import com.hy.blog.service.TypeService;
import com.hy.blog.vo.DataStringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDAO typeDAO;

    @Override
    public List<Type> findBlogType() {
        return typeDAO.findBlogType();
    }

    @Override
    public List<DataStringValue> findHomeType() {
        return typeDAO.findHomeType();
    }

    @Override
    public List<DataStringValue> findAllType() {
        return typeDAO.findAllType();
    }

}
