package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.User;
import org.apache.ibatis.annotations.Param;

public interface AdminUserDAO {

    User findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    User findByEmail(@Param("email") String email);

}
