package com.hy.blog.dao;

import com.hy.blog.entity.Tag;
import com.hy.blog.vo.DataStringValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDAO {

    List<Tag> findBlogTag();

    Tag findByTagId(@Param("tagId") Long tagId);

    List<DataStringValue> findHomeTag();

    List<DataStringValue> findAllTag();

}
