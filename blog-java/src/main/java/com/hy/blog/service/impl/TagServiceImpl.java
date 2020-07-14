package com.hy.blog.service.impl;

import com.hy.blog.dao.TagDAO;
import com.hy.blog.entity.Tag;
import com.hy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Tag> findBlogTag() {
        return tagDAO.findBlogTag();
    }

}
