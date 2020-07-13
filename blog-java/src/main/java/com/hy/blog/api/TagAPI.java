package com.hy.blog.api;

import com.hy.blog.entity.Tag;
import com.hy.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagAPI {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public List<Tag> tags() {
        return tagService.findBlogTag();
    }

    @GetMapping("/tag")
    public Tag tagBlog(Long tagId) {
        return tagService.findByTagId(tagId);
    }

}
