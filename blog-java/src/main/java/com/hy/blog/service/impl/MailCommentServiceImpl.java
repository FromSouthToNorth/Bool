package com.hy.blog.service.impl;

import com.hy.blog.dao.BlogDAO;
import com.hy.blog.dao.adminDAO.AdminUserDAO;
import com.hy.blog.entity.User;
import com.hy.blog.service.MailCommentService;
import com.hy.blog.vo.MailComment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailCommentServiceImpl implements MailCommentService {

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private BlogDAO blogDAO;

    @Resource
    private AdminUserDAO adminUserDAO;

    @Resource
    private JavaMailSender sender;

    @Override
    public void send(MailComment mailComment) {
        String comment;
        String byIdBlogTitle = blogDAO.findByIdBlogTitle(mailComment.getBlogId());
        MimeMessage mimeMessage = sender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            if (StringUtils.isEmpty(mailComment.getMail())) {
                mimeMessageHelper.setTo(from);
            } else {
                mimeMessageHelper.setTo(mailComment.getMail());
            }

            if (mailComment.getCommentId() != -1) {
                comment = mailComment.getREPLY();
            } else {
                comment = mailComment.getCOMMENT();
            }

            User byEmail = adminUserDAO.findByEmail(mailComment.getEmail());
            if (byEmail != null) {
                mailComment.setNikName("博主");
            }

            mimeMessageHelper.setSubject(mailComment.getNikName() + " " + comment +"您："+ byIdBlogTitle);
            String contentHtml = "<p>" + mailComment.getContent() + "</p>" +
                    "<a href=\"http://hyzt.vip/blog/" + mailComment.getBlogId() +"\"" + "  target=\"_blank\" style=\"color: #409EFF\">去看看</a>";
            mimeMessageHelper.setText(contentHtml, true);
            sender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
