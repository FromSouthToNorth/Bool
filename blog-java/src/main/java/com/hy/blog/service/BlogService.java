package com.hy.blog.service;

import com.hy.blog.entity.Blog;
import com.hy.blog.vo.RecommendBlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogService {

    List<Blog> findAllBlog();

    Blog findByIdBlogOne(Long id, Boolean isAdd);

    void updateByIdBlogViews(Blog blog);

    List<RecommendBlog> findRecommendBlog();

    List<Blog> findByTypeIdBlog(@Param("typeId") Long typeId);

    List<Blog> findByTagIdBlog(@Param("tagId") Long tagId);

    Map<String, List<Blog>> archiveBlog();

    Integer countBlog();

}
