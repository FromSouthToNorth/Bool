package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminLogDAO;
import com.hy.blog.entity.Log;
import com.hy.blog.service.adminService.AdminLogServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminLogServeImpl implements AdminLogServe {

    @Autowired
    private AdminLogDAO adminLogDAO;

    @Override
    @Transactional
    public void saveBog(Log log) {
        adminLogDAO.saveBog(log);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Log> findAllLog() {
        return adminLogDAO.findAllLog();
    }

    @Override
    public Integer deleteById(Long id) {
        return adminLogDAO.deleteById(id);
    }

}
