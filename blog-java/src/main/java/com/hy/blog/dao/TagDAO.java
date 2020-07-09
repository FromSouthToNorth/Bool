package com.hy.blog.dao;

import com.hy.blog.entity.Tag;

import java.util.List;

public interface TagDAO {

    List<Tag> findBlogTag();

}
