package com.hy.blog.api.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.blog.entity.Blog;
import com.hy.blog.service.adminService.AdminBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminBlogAPI {

    @Autowired
    private AdminBlogService adminBlogService;

    @GetMapping("/blogs")
    public PageInfo<Blog> blogs(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Blog> allBlog = adminBlogService.findAllBlog();
        return new PageInfo<>(allBlog);
    }

}
