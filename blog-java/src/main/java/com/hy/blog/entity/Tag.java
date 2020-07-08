package com.hy.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// 标签
public class Tag {

    private Long id;
    @NotBlank(message = "标签名称不能为空")
    private String name;

    private List<Blog> blogs;

}
