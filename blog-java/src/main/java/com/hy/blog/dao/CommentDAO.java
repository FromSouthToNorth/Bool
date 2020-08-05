package com.hy.blog.dao;

import com.hy.blog.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDAO {

    int saveComment(Comment comment);

    List<Comment> findByBlogIdComment(@Param("blogId") Long blogId);

    List<Comment> findChildComment(@Param("id") Long id);

    // 查询一级回复
    List<Comment> findByBlogIdAndParentId(@Param("blogId") Long blogId,@Param("parentId") Long parentId);

    // 查询二级回复
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Long blogId, @Param("childId") Long childId);

    Long findByBlogIdCountComment(@Param("blogId") Long blogId);

    Integer findByIdDelete(@Param("id") Long id);

    // 查询子 id
    Long findByParentIdSonId(@Param("id") Long id);

}
