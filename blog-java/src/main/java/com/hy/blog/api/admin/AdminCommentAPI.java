package com.hy.blog.api.admin;

import com.hy.blog.entity.Comment;
import com.hy.blog.service.CommentService;
import com.hy.blog.service.adminService.AdminCommentService;
import com.hy.blog.vo.CommentVO;
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
    private AdminCommentService adminCommentService;

    @GetMapping("/comment")
    public CommentVO getByIdComment(Long id) {
        return adminCommentService.findByBlogIdOne(id);
    }

    @GetMapping("/comments")
    public CommentVO comment() {
        return adminCommentService.findAllComment();
    }

    @GetMapping("/deletecomment")
    public Integer delete(Long id) {
        return adminCommentService.findByIdDelete(id);
    }

}
