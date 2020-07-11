package com.hy.blog.service.impl;

import com.hy.blog.dao.BlogAndTagDAO;
import com.hy.blog.dao.BlogDAO;
import com.hy.blog.dao.CommentDAO;
import com.hy.blog.entity.Blog;
import com.hy.blog.entity.BlogAndTag;
import com.hy.blog.exception.NotFoundException;
import com.hy.blog.service.BlogService;
import com.hy.blog.utils.MarkdownUtils;
import com.hy.blog.vo.RecommendBlog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDAO blogDAO;

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private BlogAndTagDAO blogAndTagDAO;

    @Override
    public List<Blog> findAllBlog() {
        List<Blog> allBlog = blogDAO.findAllBlog();
        for (Blog blog : allBlog) {
            blog.setCommentTotal(commentDAO.findByBlogIdCountComment(blog.getId()));
            blog.setTags(blogAndTagDAO.findByBlogId(blog.getId()));
        }
        return allBlog;
    }

    @Override
    public Blog findByIdBlogOne(Long id, Boolean isAdd) {
        Blog byIdBlogOne = blogDAO.findByIdBlogOne(id);
        byIdBlogOne.setCommentTotal(commentDAO.findByBlogIdCountComment(byIdBlogOne.getId()));
        byIdBlogOne.setTags(blogAndTagDAO.findByBlogId(byIdBlogOne.getId()));
        if (byIdBlogOne == null) {
            throw new NotFoundException("抱歉~该博客不存在");
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(byIdBlogOne, blog);
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        if (isAdd) {
            updateByIdBlogViews(blog);
        }
        return blog;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateByIdBlogViews(Blog blog) {
        Blog byIdBlogOne = blogDAO.findByIdBlogOne(blog.getId());
        byIdBlogOne.setViews(byIdBlogOne.getViews() + 1);
        blogDAO.updateByIdBlogViews(byIdBlogOne);
    }

    @Override
    public List<RecommendBlog> findRecommendBlog() {
        return blogDAO.findRecommendBlog();
    }

}
