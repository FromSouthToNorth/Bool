package com.hy.blog.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

// 标签
public class Tag {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @NotBlank(message = "标签名称不能为空")
    private String name;
    private String tagColour;

    private List<Blog> blogs;

    public Tag() {
    }

    public Tag(Long id, @NotBlank(message = "标签名称不能为空") String name, String tagColour, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.tagColour = tagColour;
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagColour() {
        return tagColour;
    }

    public void setTagColour(String tagColour) {
        this.tagColour = tagColour;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

}
