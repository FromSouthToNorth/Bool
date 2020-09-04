package com.hy.blog.api;

import com.hy.blog.service.MailCommentService;
import com.hy.blog.vo.MailComment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MailCommentAPI {

    @Resource
    private MailCommentService commentService;

    @PostMapping("/sendmail")
    public void send(MailComment comment) {
        System.out.println(comment);
        commentService.send(comment);
    }

}
