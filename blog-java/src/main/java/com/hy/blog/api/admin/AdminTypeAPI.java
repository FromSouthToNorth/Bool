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

    @GetMapping("/pagetypes")
    public PageInfo<Type> types(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<Type> allType = adminTypeService.findAllType();
        return new PageInfo<>(allType);
    }

    @GetMapping("/types")
    public List<Type> types() {
        return adminTypeService.findAllType();
    }

    @PostMapping("/types")
    public Integer post(Type type) {
        if (type.getName() == null) {
            return 3;
        }
        Integer integer;
        if (type.getId() != null) {
            integer = adminTypeService.updateByIdType(type);
        } else {
            Type byNameType = adminTypeService.findByNameType(type.getName());
            if (byNameType != null) {
                return 1;
            }
            integer = adminTypeService.saveType(type.getName());
        }
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

    @PostMapping("/deleteType")
    public Integer delete(Long id) {
       return adminTypeService.deleteByIdType(id);
    }

}
