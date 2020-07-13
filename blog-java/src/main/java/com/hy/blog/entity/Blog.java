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
// 博客
public class Blog {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private Integer like;
    private Boolean appreciation;
    private Boolean shareStatement;
    private Boolean commentabled;
    private Boolean published;
    private Boolean recommend;
    private Date createTime;
    private Date updateTime;
    private Long typeId;
    private Long userId;
    private String description;
    private String tagIds;
    private Long commentTotal;

    private Type type;
    private List<Tag> tags;
    private List<Comment> comments;
    private User user;

}
