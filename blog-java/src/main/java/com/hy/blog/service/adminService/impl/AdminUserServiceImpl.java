package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminUserDAO;
import com.hy.blog.entity.User;
import com.hy.blog.service.adminService.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDAO adminUserDAO;

    @Override
    public User adminLogin(String userName, String password) {
        return adminUserDAO.findByUserNameAndPassword(userName, password);
    }

    @Override
    public User findByEmailAdmin(String email) {
        return adminUserDAO.findByEmail(email);
    }
}
