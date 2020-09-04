package com.hy.blog.vo;

public class MailComment {

    private final String COMMENT = "评论了";
    private final String REPLY = "回复了";

    private Long commentId;
    private Long blogId;
    private String nikName;
    private String content;

    public MailComment() {
    }

    public MailComment(String nikName, String content) {
        this.nikName = nikName;
        this.content = content;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getCOMMENT() {
        return COMMENT;
    }

    public String getREPLY() {
        return REPLY;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailComment{" +
                "COMMENT='" + COMMENT + '\'' +
                ", REPLY='" + REPLY + '\'' +
                ", commentId=" + commentId +
                ", blogId=" + blogId +
                ", nikName='" + nikName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
