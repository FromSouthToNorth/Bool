package com.hy.blog.service;

import com.hy.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findByBlogIdComment(Long blogId);

    Integer saveComment(Comment comment);

    // 查询子评论
    List<Comment> findChildComment(Long id);

}
