package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminUserDAO;
import com.hy.blog.entity.User;
import com.hy.blog.service.adminService.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDAO adminUserDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User adminLogin(String userName, String password) {
        return adminUserDAO.findByUserNameAndPassword(userName, password);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User findByEmailAdmin(String email) {
        return adminUserDAO.findByEmail(email);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void updateLoginTime(User user) {
        adminUserDAO.updateLoginItem(user);
    }
}
