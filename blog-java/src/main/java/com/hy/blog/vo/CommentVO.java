package com.hy.blog.vo;

import com.hy.blog.entity.Comment;

import java.util.List;
import java.util.Map;

public class CommentVO {

    private Boolean isComment;
    private Map<String, List<Comment>> map;

    public CommentVO() {
    }

    public CommentVO(Boolean isComment, Map<String, List<Comment>> map) {
        this.isComment = isComment;
        this.map = map;
    }

    public Boolean getComment() {
        return isComment;
    }

    public void setComment(Boolean comment) {
        isComment = comment;
    }

    public Map<String, List<Comment>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Comment>> map) {
        this.map = map;
    }

}
