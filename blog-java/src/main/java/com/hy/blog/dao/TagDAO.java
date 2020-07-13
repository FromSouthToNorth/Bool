package com.hy.blog.dao;

import com.hy.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDAO {

    List<Tag> findBlogTag();

    Tag findByTagId(@Param("tagId") Long tagId);

}
