package com.hy.blog.api.admin;

import com.hy.blog.entity.Comment;
import com.hy.blog.service.CommentService;
import com.hy.blog.service.adminService.AdminCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminCommentAPI {

    @Autowired
    private CommentService commentService;

    @Autowired
    private AdminCommentService adminCommentService;

    @GetMapping("/comment")
    public List<Comment> getByIdComment(Long id) {
        return commentService.findByBlogIdComment(id);
    }

    @GetMapping("/comments")
    public Map<String, List<Comment>> comment() {
        return adminCommentService.findAllComment();
    }

    @GetMapping("/deletecomment")
    public Integer delete(Long id) {
        return adminCommentService.findByIdDelete(id);
    }

}
