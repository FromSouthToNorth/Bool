package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.BlogAndTag;
import org.apache.ibatis.annotations.Param;

public interface AdminBlogAndTagDAO {

    Integer saveBlogAndTag(BlogAndTag blogAndTag);

    Integer deleteByBlogId(@Param("blogId") Long blogId);

    Integer deleteByTagId(@Param("tagId") Long tagId);

}
