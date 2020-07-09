package com.hy.blog.service.adminService.impl;

import com.hy.blog.dao.adminDAO.AdminTagDAO;
import com.hy.blog.entity.Tag;
import com.hy.blog.service.adminService.AdminTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminTagServiceImpl implements AdminTagService {

    @Autowired
    private AdminTagDAO adminTagDAO;

    @Override
    public Integer saveTag(String name) {
        return adminTagDAO.saveTag(name);
    }

    @Override
    public Tag findByIdTag(Long id) {
        return adminTagDAO.findByIdTag(id);
    }

    @Override
    public Integer deleteByIdTag(Long id) {
        return adminTagDAO.deleteByIdTag(id);
    }

    @Override
    public Integer updateByIdTag(Tag tag) {
        return adminTagDAO.updateByIdTag(tag);
    }

    @Override
    public List<Tag> findAllTag() {
        return adminTagDAO.findAllTag();
    }

    @Override
    public Tag findByNameTag(String name) {
        return adminTagDAO.findByNameTag(name);
    }

    @Override
    public List<Tag> findTagByStringId(String stringId) {
        List<Tag> tags = new ArrayList<>();
        List<Long> longs = convertToList(stringId);
        for (Long aLong : longs) {
            tags.add(adminTagDAO.findByIdTag(aLong));
        }
        return tags;
    }

    //接收页面传来的tag.id集合
    //格式为字符串形式，转换为整型
    private List<Long> convertToList(String stringId) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(stringId) && stringId != null) {
            String[] split = stringId.split(",");
            for (String s : split) {
                list.add(new Long(s));
            }
        }
        return list;
    }

}
