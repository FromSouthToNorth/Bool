package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminBlogDAO;
import com.hy.blog.dao.adminDAO.AdminTagDAO;
import com.hy.blog.dao.adminDAO.AdminTypeDAO;
import com.hy.blog.service.adminService.AdminTotalService;
import com.hy.blog.vo.TypeRoTagRoBlogTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminTotalServiceImpl implements AdminTotalService {

    @Autowired
    private AdminBlogDAO adminBlogDAO;

    @Autowired
    private AdminTypeDAO adminTypeDAO;

    @Autowired
    private AdminTagDAO adminTagDAO;

    @Override
    public TypeRoTagRoBlogTotal findTotal() {
        return new TypeRoTagRoBlogTotal(adminTypeDAO.countType(), adminTagDAO.countTag(), adminBlogDAO.countBlog());
    }
}
