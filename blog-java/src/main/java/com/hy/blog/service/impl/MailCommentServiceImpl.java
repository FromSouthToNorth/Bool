package com.hy.blog.service.impl;

import com.hy.blog.dao.BlogDAO;
import com.hy.blog.service.MailCommentService;
import com.hy.blog.vo.MailComment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MailCommentServiceImpl implements MailCommentService {

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private BlogDAO blogDAO;

    @Resource
    private JavaMailSender sender;

    @Override
    public void send(MailComment mailComment) {
        String comment;
        String byIdBlogTitle = blogDAO.findByIdBlogTitle(mailComment.getBlogId());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(from);
        if (mailComment.getCommentId() != -1) {
            comment = mailComment.getREPLY();
        } else {
            comment = mailComment.getCOMMENT();
        }
        System.out.println(mailComment + "  " + comment);
        message.setSubject(mailComment.getNikName() + " " + comment +"："+ byIdBlogTitle);
        message.setText(mailComment.getContent());
        sender.send(message);
    }
}
