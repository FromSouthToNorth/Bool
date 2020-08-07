package com.hy.blog.service.adminService;

import com.hy.blog.vo.DataBar;
import com.hy.blog.vo.DataStringValue;

import java.util.List;

public interface AdminDataService {

    List<DataStringValue> findTagPie();

    List<String> findTagName();

    DataBar findTypeBar();

}
