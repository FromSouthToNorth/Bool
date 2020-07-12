package com.hy.blog.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 评论
public class Comment {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long blogId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentCommentId;
    private Boolean adminComment;
    private String parentNickname;

    private Blog blog;

    private List<Comment> replyComments;
    private Comment parentComment;

}
