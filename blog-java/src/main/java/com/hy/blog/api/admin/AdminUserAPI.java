package com.hy.blog.api.admin;

import com.hy.blog.entity.User;
import com.hy.blog.service.adminService.AdminUserService;
import com.hy.blog.utils.MD5Utils;
import com.hy.blog.vo.DataBar;
import com.hy.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @GetMapping("/user")
    public UserVO getUser(HttpSession session) {
        UserVO user = new UserVO();
        User attribute = (User) session.getAttribute("user");
        user.setId(attribute.getId());
        user.setAvatar(attribute.getAvatar());
        user.setNickname(attribute.getNickname());
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        user.setLoginTime(dateFormat.format(attribute.getLoginTime()));
        return user;
    }

    @GetMapping("/islogin")
    public Integer isLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return 1;
        } else {
            return 0;
        }
    }

    // 注销
    @GetMapping("/logout")
    public Integer logout(HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setLoginTime(new Date());
        adminUserService.updateLoginTime(user);
        session.removeAttribute("user");
        return 1;
    }

}
