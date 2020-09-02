package com.hy.blog.entity;



public class BlogAndTag {

    private Long blogId;
    private Long tagsId;

    public BlogAndTag() {
    }

    public BlogAndTag(Long blogId, Long tagsId) {
        this.blogId = blogId;
        this.tagsId = tagsId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }
}
