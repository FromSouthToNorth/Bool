package com.hy.blog.api.admin;

import com.hy.blog.entity.User;
import com.hy.blog.service.adminService.AdminUserService;
import com.hy.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminUserAPI {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public Integer login(@RequestParam String userName, @RequestParam String password, HttpSession session) {

        if (userName == null || password == null) {
            return 1;
        }
        User user = adminUserService.adminLogin(userName, MD5Utils.code(password));
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return 0;  // 登录成功
        } else {
            return 2;  // 密码错误
        }

    }

}
