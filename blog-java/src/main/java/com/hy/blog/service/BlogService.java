package com.hy.blog.service;

import com.hy.blog.entity.Blog;
import com.hy.blog.vo.RecommendBlog;

import java.util.List;

public interface BlogService {

    List<Blog> findAllBlog();

    Blog findByIdBlogOne(Long id, Boolean isAdd);

    void updateByIdBlogViews(Blog blog);

    List<RecommendBlog> findRecommendBlog();

}
