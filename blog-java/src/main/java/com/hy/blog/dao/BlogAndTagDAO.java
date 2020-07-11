package com.hy.blog.dao;

import com.hy.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogAndTagDAO {

    List<Tag> findByBlogId(@Param("blogId") Long blogId);

}
