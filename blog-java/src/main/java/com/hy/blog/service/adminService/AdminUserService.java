package com.hy.blog.service.adminService;

import com.hy.blog.entity.User;

public interface AdminUserService {

    User adminLogin(String userName, String password);

    User findByEmailAdmin(String email);

    void updateLoginTime(User user);
}
