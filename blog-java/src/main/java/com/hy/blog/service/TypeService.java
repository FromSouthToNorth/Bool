package com.hy.blog.service;

import com.hy.blog.entity.Type;
import com.hy.blog.vo.DataStringValue;

import java.util.List;

public interface TypeService {

    List<Type> findBlogType();

    List<DataStringValue> findHomeType();

    List<DataStringValue> findAllType();

}
