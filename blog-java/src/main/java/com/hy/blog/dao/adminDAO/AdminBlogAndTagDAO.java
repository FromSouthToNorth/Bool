package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.BlogAndTag;
import com.hy.blog.vo.DataStringValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminBlogAndTagDAO {

    Integer saveBlogAndTag(BlogAndTag blogAndTag);

    Integer deleteByBlogId(@Param("blogId") Long blogId);

    Integer deleteByTagId(@Param("tagId") Long tagId);

    List<DataStringValue> findTagPie();

}
