package com.hy.blog.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.blog.entity.Blog;
import com.hy.blog.entity.Type;
import com.hy.blog.service.BlogService;
import com.hy.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeAPI {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types")
    public List<Type> types() {
        return typeService.findBlogType();
    }

    @GetMapping("/blogType")
    public PageInfo<Blog> typeBlog(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Long typeId) {
        PageHelper.startPage(pageNum, 5);
        List<Blog> byTypeIdBlog = blogService.findByTypeIdBlog(typeId);
        return new PageInfo<>(byTypeIdBlog, 4);
    }

}
