package com.hy.blog.api.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.blog.entity.Type;
import com.hy.blog.service.adminService.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminTypeAPI {

    @Autowired
    private AdminTypeService adminTypeService;

    @GetMapping("/types")
    public PageInfo<Type> tags(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Type> allType = adminTypeService.findAllType();
        return new PageInfo<>(allType);
    }

    @PostMapping("/types")
    public Integer post(@RequestParam String name) {
        Type byNameType = adminTypeService.findByNameType(name);
        if (byNameType != null) {
            return 1;
        }
        Integer integer = adminTypeService.saveType(name);
        if (integer < 0) {
            return 2;
        } else {
            return 0;
        }
    }

    @GetMapping("/type")
    public Type editInput(Long id) {
        return adminTypeService.findByIdType(id);
    }

    @PostMapping("/type")
    public Integer editPost(Type type) {
        if (type.getId() == null || type.getName() == null) {
            return 2;
        }
        Type byNameType = adminTypeService.findByNameType(type.getName());
        if (byNameType != null) {
            return 1;
        }
        Integer integer = adminTypeService.updateByIdType(type);
        if (integer < 0) {
            return 3;
        } else {
            return 0;
        }
    }

    @PostMapping("/deleteType")
    public Integer delete(Long id) {
        if (adminTypeService.deleteByIdType(id) > 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
