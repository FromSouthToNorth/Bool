package com.hy.blog.service.adminService;

import com.hy.blog.entity.Blog;
import com.hy.blog.vo.BlogQuery;

import java.util.List;
import java.util.Map;

public interface AdminBlogService {

    List<Blog> findAllBlog();

    Blog findByIdBlogOne(Long id);

    Integer updateByIdBlog(Blog blog);

    Integer deleteByIdBlog(Long id);

    Integer saveBlog(Blog blog);

    List<Blog> findByTitleRoTypeRoRecommend(BlogQuery blogQuery);

}
