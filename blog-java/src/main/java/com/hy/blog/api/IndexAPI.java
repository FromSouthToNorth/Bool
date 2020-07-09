package com.hy.blog.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.blog.entity.Blog;
import com.hy.blog.entity.Tag;
import com.hy.blog.entity.Type;
import com.hy.blog.service.BlogService;
import com.hy.blog.service.TagService;
import com.hy.blog.service.TypeService;
import com.hy.blog.vo.RecommendBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class IndexAPI {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public PageInfo<Blog> blogs(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Blog> allBlog = blogService.findAllBlog();
        return new PageInfo<>(allBlog);
    }

    @GetMapping("/blog")
    public Blog blog(@RequestParam Long id, HttpSession session) {
        boolean isAdd = true;
        try {
            long time = (long) session.getAttribute("addTime");
            if (System.currentTimeMillis() - time < 5000) {
                isAdd = false;
            }
        } catch (Exception e) {
        } finally {
            session.setAttribute("addTime", System.currentTimeMillis());
        }
        System.out.println(isAdd);
        return blogService.findByIdBlogOne(id, isAdd);
    }

    @GetMapping("/homeTags")
    public List<Tag> tags() {
        return tagService.findBlogTag();
    }

    @GetMapping("/homeTypes")
    public List<Type> types() {
        return typeService.findBlogType();
    }

    @GetMapping("/recommendBlogs")
    public List<RecommendBlog> recommendBlogs() {
        return blogService.findRecommendBlog();
    }

}
