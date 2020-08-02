package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AdminUserDAO {

    User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    User findByEmail(@Param("email") String email);

    void updateLoginItem(User user);

}
