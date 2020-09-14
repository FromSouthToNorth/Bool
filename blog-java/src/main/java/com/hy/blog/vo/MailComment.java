package com.hy.blog.vo;

public class MailComment {

    private final String COMMENT = "评论了";
    private final String REPLY = "回复了";

    private Long   commentId;
    private Long   blogId;
    private String nikName;
    private String content;
    private String mail;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
                ", mail='" + mail + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
