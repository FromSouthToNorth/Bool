package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.CommentDAO;
import com.hy.blog.entity.Blog;
import com.hy.blog.entity.Comment;
import com.hy.blog.service.CommentService;
import com.hy.blog.service.adminService.AdminBlogService;
import com.hy.blog.service.adminService.AdminCommentService;
import com.hy.blog.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminCommentServiceImpl implements AdminCommentService {

    @Autowired
    private AdminBlogService adminBlogService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentDAO commentDAO;

    // 用于装载子 id 的容器
    private List<Long> sonIds = new ArrayList<>();

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public CommentVO findAllComment() {
        Map<String, List<Comment>> map = new LinkedHashMap<>();
        List<Blog> allBlog = adminBlogService.findAllBlog();
        List<Comment> comments;
        for (Blog blog : allBlog) {
            comments = commentService.findByBlogIdComment(blog.getId());
            if (comments.size() > 0) {
                map.put(blog.getTitle(), comments);
            }
        }
        return new CommentVO(map.size() != 0, map);
    }

    @Override
    @Transactional
    public Integer findByIdDelete(Long id) {
        findSonId(id);
        if (sonIds.size() > 0) {
            for (Long sonId : sonIds) {
                commentDAO.findByIdDelete(sonId);
            }
        }
        sonIds = new ArrayList<>();
        return commentDAO.findByIdDelete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public CommentVO findByBlogIdOne(Long id) {
        Map<String, List<Comment>> map = new LinkedHashMap<>();
        Blog byIdBlogOne = adminBlogService.findByIdBlogOne(id);
        List<Comment> byBlogIdComment = commentService.findByBlogIdComment(id);
        if (byBlogIdComment.size()> 0) {
            map.put(byIdBlogOne.getTitle(), byBlogIdComment);
        }
        return new CommentVO(map.size() != 0, map);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Long findByParentIdSonId(Long id) {
        return commentDAO.findByParentIdSonId(id);
    }

    // 根据传递的id查询子评论id
    private void findSonId(Long id) {
        Long byParentIdSonId = findByParentIdSonId(id);
        // 没有查到子 id (byParentIdSonId == null) 跳出递归
        if (byParentIdSonId != null) {
            sonIds.add(byParentIdSonId);
            findSonId(byParentIdSonId);
        }
    }

}
