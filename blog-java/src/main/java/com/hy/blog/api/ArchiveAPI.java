package com.hy.blog.api;

import com.hy.blog.entity.Blog;
import com.hy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ArchiveAPI {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogTotal")
    public Integer getBlogTotal() {
        return blogService.countBlog();
    }

    @GetMapping("/blogArchive")
    public Map<String, List<Blog>> archiveMap() {
        return blogService.archiveBlog();
    }

}
