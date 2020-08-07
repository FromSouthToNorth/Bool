package com.hy.blog.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.blog.entity.Blog;
import com.hy.blog.entity.Tag;
import com.hy.blog.service.BlogService;
import com.hy.blog.service.TagService;
import com.hy.blog.vo.DataStringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagAPI {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags")
    public List<DataStringValue> tags() {
        return tagService.findAllTat();
    }

    @GetMapping("/blogTag")
    public PageInfo<Blog> tagBlog(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Long tagId) {
        PageHelper.startPage(pageNum, 5);
        List<Blog> byTagIdBlog = blogService.findByTagIdBlog(tagId);
        return new PageInfo<>(byTagIdBlog, 4);
    }

}
