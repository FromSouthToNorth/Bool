package com.hy.blog.service.impl;

import com.hy.blog.dao.TagDAO;
import com.hy.blog.entity.Tag;
import com.hy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDAO;

    @Override
    public List<Tag> findBlogTag() {
        return tagDAO.findBlogTag();
    }

    @Override
    public Tag findByTagId(Long tagId) {
        return tagDAO.findByTagId(tagId);
    }

}
