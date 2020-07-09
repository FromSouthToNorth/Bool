package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminBlogDAO;
import com.hy.blog.entity.Blog;
import com.hy.blog.service.adminService.AdminBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBlogServiceImpl implements AdminBlogService {

    @Autowired
    private AdminBlogDAO adminBlogDAO;

    @Override
    public List<Blog> findAllBlog() {
        return adminBlogDAO.findAllBlog();
    }

}
