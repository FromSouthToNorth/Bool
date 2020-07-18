package com.hy.blog.service.adminService;

import com.hy.blog.entity.Log;

import java.util.List;

public interface AdminLogServe {

    void saveBog(Log log);

    List<Log> findAllLog();

    Integer deleteById(Long id);

}
