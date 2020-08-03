package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminBlogAndTagDAO;
import com.hy.blog.dao.adminDAO.AdminBlogDAO;
import com.hy.blog.dao.adminDAO.AdminTagDAO;
import com.hy.blog.dao.adminDAO.AdminTypeDAO;
import com.hy.blog.entity.Tag;
import com.hy.blog.entity.Type;
import com.hy.blog.service.adminService.AdminDataService;
import com.hy.blog.vo.DataBar;
import com.hy.blog.vo.DataPie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDataServiceImpl implements AdminDataService {

    @Autowired
    private AdminTypeDAO adminTypeDAO;

    @Autowired
    private AdminTagDAO adminTagDAO;

    @Autowired
    private AdminBlogDAO adminBlogDAO;

    @Autowired
    private AdminBlogAndTagDAO adminBlogAndTagDAO;

    @Override
    public List<DataPie> findTagPie() {
        return adminBlogAndTagDAO.findTagPie();
    }

    @Override
    @Transactional
    public List<String> findTagName() {
        List<Tag> allTag = adminTagDAO.findAllTag();
        List<String> names = new ArrayList<>();
        for (Tag tag : allTag) {
            names.add(tag.getName());
        }
        return names;
    }

    @Override
    @Transactional
    public DataBar findTypeBar() {
        List<Type> allType = adminTypeDAO.findAllType();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (Type type : allType) {
            names.add(type.getName());
            values.add(adminBlogDAO.findByTypeIdCountBlog(type.getId()));
        }
        return new DataBar(names, values);
    }
}
