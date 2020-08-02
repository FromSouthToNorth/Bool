package com.hy.blog.api.admin;

import com.hy.blog.service.adminService.AdminTotalService;
import com.hy.blog.service.adminService.AdminDataService;
import com.hy.blog.vo.DataBar;
import com.hy.blog.vo.DataPie;
import com.hy.blog.vo.TypeRoTagRoBlogTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminTotalAPI {

    @Autowired
    private AdminTotalService adminTotalService;

    @Autowired
    private AdminDataService adminDataService;

    @GetMapping("/ttbtotal")
    public TypeRoTagRoBlogTotal total() {
        return adminTotalService.findTotal();
    }

    @GetMapping("/tagdata")
    public List<DataPie> typeData() {
        return adminDataService.findTagPie();
    }

    @GetMapping("/tagname")
    public List<String> tagName() {
        return adminDataService.findTagName();
    }

    @GetMapping("/typebar")
    public DataBar typeBar() {
        return adminDataService.findTypeBar();
    }

}
