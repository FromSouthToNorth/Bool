package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.Blog;

import java.util.List;

public interface AdminBlogDAO {

    List<Blog> findAllBlog();

    Blog findByIdBlogOne(Long id);

    Integer updateByIdBlog(Blog blog);

    Integer deleteByIdBlog(Long id);

    Integer saveBlog(Blog blog);

}
