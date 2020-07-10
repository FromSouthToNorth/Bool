package com.hy.blog.api.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.blog.entity.Blog;
import com.hy.blog.entity.User;
import com.hy.blog.service.adminService.AdminBlogService;
import com.hy.blog.service.adminService.AdminTagService;
import com.hy.blog.utils.UuidUtils;
import com.hy.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminBlogAPI {

    @Autowired
    private AdminBlogService adminBlogService;

    @Autowired
    private AdminTagService adminTagService;

    @GetMapping("/blogs")
    public PageInfo<Blog> blogs(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Blog> allBlog = adminBlogService.findAllBlog();
        return new PageInfo<>(allBlog);
    }

    @PostMapping("/blogs")
    public Integer post(Blog blog, HttpSession session) {
        // 在session中获取管理员 ID
        User user = (User) session.getAttribute("user");
        blog.setUserId(user.getId());
        blog.setTags(adminTagService.findTagByStringId(blog.getTagIds()));
        if (blog.getId() == null) {
            blog.setId(UuidUtils.getId());
            return adminBlogService.saveBlog(blog);
        } else {
            return adminBlogService.updateByIdBlog(blog);
        }
    }

    @PostMapping("/blog/search")
    public PageInfo<Blog> search(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, BlogQuery blogQuery) {
        PageHelper.startPage(pageNum, 6);
        List<Blog> byTitleRoTypeRoRecommend = adminBlogService.findByTitleRoTypeRoRecommend(blogQuery);
        System.out.println(byTitleRoTypeRoRecommend);
        return new PageInfo<>(byTitleRoTypeRoRecommend);
    }

    @GetMapping("/blog/delete")
    public Integer delete(@RequestParam Long id) {
        return adminBlogService.deleteByIdBlog(id);
    }

}
