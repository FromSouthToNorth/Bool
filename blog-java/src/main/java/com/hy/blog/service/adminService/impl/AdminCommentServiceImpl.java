package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.CommentDAO;
import com.hy.blog.dao.adminDAO.AdminBlogDAO;
import com.hy.blog.entity.Blog;
import com.hy.blog.entity.Comment;
import com.hy.blog.service.CommentService;
import com.hy.blog.service.adminService.AdminCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminCommentServiceImpl implements AdminCommentService {

    @Autowired
    private AdminBlogDAO adminBlogDAO;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Map<String, List<Comment>> findAllComment() {
        Map<String, List<Comment>> map = new LinkedHashMap<>();
        List<Blog> allBlog = adminBlogDAO.findAllBlog();
        List<Comment> comments;
        for (Blog blog : allBlog) {
            comments = commentService.findByBlogIdComment(blog.getId());
            if (comments.size() > 0) {
                map.put(blog.getTitle(), comments);
            }
        }
        return map;
    }

    @Override
    @Transactional
    public Integer findByIdDelete(Long id) {
        return commentDAO.findByIdDelete(id);
    }
}
