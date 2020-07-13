package com.hy.blog.api;

import com.hy.blog.entity.Comment;
import com.hy.blog.entity.User;
import com.hy.blog.service.CommentService;
import com.hy.blog.service.adminService.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentAPI {

    @Autowired
    private CommentService commentService;

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/comments")
    public List<Comment> comments(@RequestParam Long blogId) {
        return commentService.findByBlogIdComment(blogId);
    }

    @PostMapping("/comments")
    public Integer post(Comment comment, HttpSession session) {
        // 存储时间，防止耍评论
        try {
            long time = (long) session.getAttribute("time");
            if (System.currentTimeMillis() - time < 5000) {
                return 2;
            }
        } catch (Exception e){
        } finally {
            session.setAttribute("time", System.currentTimeMillis());
        }
        // 判断评论参数是否完整
        if (comment.getBlog() == null ||
            comment.getNickname() == null ||
            comment.getContent() == null) {
            return 1;
        }
        User byEmailAdmin = adminUserService.findByEmailAdmin(comment.getEmail());
        if (byEmailAdmin != null) {
            comment.setAvatar(byEmailAdmin.getAvatar());
            comment.setNickname(byEmailAdmin.getNickname());
            comment.setAdminComment(true);
        } else {
            comment.setAdminComment(false);
        }
        Integer integer = commentService.saveComment(comment);
        if (integer > 0) {
            return 0;
        } else {
            return 1;
        }

    }

}
