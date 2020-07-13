package com.hy.blog.api;

import com.hy.blog.entity.Type;
import com.hy.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeAPI {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public List<Type> types() {
        return typeService.findBlogType();
    }

    @GetMapping("/type")
    public Type typeBlog(Long typeId) {
        return typeService.findByTypeId(typeId);
    }

}
