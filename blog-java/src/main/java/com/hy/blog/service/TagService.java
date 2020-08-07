package com.hy.blog.service;

import com.hy.blog.entity.Tag;
import com.hy.blog.vo.DataStringValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagService {

    List<Tag> findBlogTag();

    List<DataStringValue> findHomeTag();

    List<DataStringValue> findAllTat();

}
