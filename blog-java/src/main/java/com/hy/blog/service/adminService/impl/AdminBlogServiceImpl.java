package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminBlogAndTagDAO;
import com.hy.blog.dao.adminDAO.AdminBlogDAO;
import com.hy.blog.entity.Blog;
import com.hy.blog.entity.BlogAndTag;
import com.hy.blog.entity.Tag;
import com.hy.blog.exception.NotFoundException;
import com.hy.blog.service.adminService.AdminBlogService;
import com.hy.blog.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AdminBlogServiceImpl implements AdminBlogService {

    @Autowired
    private AdminBlogDAO adminBlogDAO;

    @Autowired
    private AdminBlogAndTagDAO adminBlogAndTagDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Blog> findAllBlog() {
        return adminBlogDAO.findAllBlog();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Blog findByIdBlogOne(Long id) {
        Blog byIdBlogOne = adminBlogDAO.findByIdBlogOne(id);
        if (byIdBlogOne == null) {
            throw new NotFoundException("抱歉该博客找不着！");
        }
        return byIdBlogOne;
    }

    @Override
    public Integer updateByIdBlog(Blog blog) {
        Blog byIdBlogOne = adminBlogDAO.findByIdBlogOne(blog.getId());
        if (byIdBlogOne == null) {
            throw new NotFoundException("抱歉该博客找不着！");
        }
        adminBlogAndTagDAO.deleteByBlogId(blog.getId());
        blog.setViews(byIdBlogOne.getViews());
        blog.setUpdateTime(new Date());
        String tagIds = blog.getTagIds();
        String[] split = tagIds.split(",");
        for (String s : split) {
            adminBlogAndTagDAO.saveBlogAndTag(new BlogAndTag(blog.getId(), Long.parseLong(s)));
        }
        blog.setViews(byIdBlogOne.getViews());
        BeanUtils.copyProperties(blog, byIdBlogOne);
        return adminBlogDAO.updateByIdBlog(blog);
    }

    @Override
    public Integer deleteByIdBlog(Long id) {
        adminBlogAndTagDAO.deleteByBlogId(id);
        return adminBlogDAO.deleteByIdBlog(id);
    }

    @Override
    public Integer saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag;
        for (Tag tag : tags) {
            blogAndTag = new BlogAndTag(blog.getId(), tag.getId());
            adminBlogAndTagDAO.saveBlogAndTag(blogAndTag);
        }
        return adminBlogDAO.saveBlog(blog);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Blog> findByTitleRoTypeRoRecommend(BlogQuery blogQuery) {
        return adminBlogDAO.findByTitleRoTypeRoRecommend(blogQuery);
    }

}
