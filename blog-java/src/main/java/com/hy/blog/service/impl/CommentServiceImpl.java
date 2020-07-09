package com.hy.blog.service.impl;

import com.hy.blog.dao.CommentDAO;
import com.hy.blog.entity.Comment;
import com.hy.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    private List<Comment> tempReplys = new ArrayList<>();

    @Override
    public List<Comment> findByBlogIdComment(Long blogId) {
        List<Comment> byBlogIdComment = commentDAO.findByBlogIdComment(blogId);
        for (Comment comment : byBlogIdComment) {
            Long id = comment.getId();
            String nickname = comment.getNickname();
            List<Comment> byBlogIdAndParentId = commentDAO.findByBlogIdAndParentId(blogId, id);
            combineChildren(blogId, byBlogIdAndParentId, nickname);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return byBlogIdComment;
    }

    @Override
    public Integer saveComment(Comment comment) {
        Long id = comment.getParentComment().getId();
        if (id != -1) {
            comment.setParentCommentId(id);
        }
        comment.setCreateTime(new Date());
        return commentDAO.saveComment(comment);
    }

    @Override
    public List<Comment> findChildComment(Long id) {
        return commentDAO.findChildComment(id);
    }

    private void combineChildren(Long blogId, List<Comment> comments, String parentNickname) {
        // 判断是否有子评论
        if (comments.size() > 0) {
            // 循环找出子评论的id
            for (Comment comment : comments) {
                String nickname = comment.getNickname();
                comment.setParentNickname(parentNickname);
                tempReplys.add(comment);
                Long id = comment.getId();
                recursively(blogId, id, nickname);
            }
        }
    }

    private void recursively(Long blogId, Long childId, String parentNickname) {
        // 根据子一级评论的id找到子二级评论
        List<Comment> comments = commentDAO.findByBlogIdAndReplayId(blogId, childId);
        if (comments.size() > 0) {
            for (Comment comment : comments) {
                String nickname = comment.getNickname();
                comment.setParentNickname(parentNickname);
                Long id = comment.getId();
                tempReplys.add(comment);
                recursively(blogId, id, nickname);
            }
        }
    }
}
