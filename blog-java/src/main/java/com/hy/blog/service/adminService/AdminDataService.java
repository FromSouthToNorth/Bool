package com.hy.blog.service.adminService;

import com.hy.blog.vo.DataBar;
import com.hy.blog.vo.DataPie;

import java.util.List;

public interface AdminDataService {

    List<DataPie> findTagPie();

    List<String> findTagName();

    DataBar findTypeBar();

}
