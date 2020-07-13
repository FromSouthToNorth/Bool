package com.hy.blog.service;

import com.hy.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagService {

    List<Tag> findBlogTag();

    Tag findByTagId(Long tagId);

}
