package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.Blog;
import com.hy.blog.vo.BlogQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminBlogDAO {

    List<Blog> findAllBlog();

    Blog findByIdBlogOne(@Param("id") Long id);

    Integer updateByIdBlog(Blog blog);

    Integer deleteByIdBlog(@Param("id") Long id);

    Integer saveBlog(Blog blog);

    List<Blog> findByTitleRoTypeRoRecommend(BlogQuery blogQuery);

}
