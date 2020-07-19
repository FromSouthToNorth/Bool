package com.hy.blog.api.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.blog.entity.Log;
import com.hy.blog.service.adminService.AdminLogServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminLogAPI {

    @Autowired
    private AdminLogServe adminLogServe;

//    @GetMapping("/logs")
//    public PageInfo<Log> log(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
//        PageHelper.startPage(pageNum, 12);
//        List<Log> allLog = adminLogServe.findAllLog();
//        return new PageInfo<>(allLog, 6);
//    }
//
//    @PostMapping("/deletelog")
//    public Integer delete(@RequestParam Long id) {
//        return adminLogServe.deleteById(id);
//    }

}
