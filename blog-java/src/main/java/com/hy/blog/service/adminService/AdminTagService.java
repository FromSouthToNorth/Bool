package com.hy.blog.service.adminService;

import com.hy.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminTagService {

    Integer saveTag(Tag tag);

    Tag findByIdTag(Long id);

    List<Tag> findTagByStringId(String stringId);

    Integer deleteByIdTag(Long id);

    Integer updateByIdTag(Tag tag);

    List<Tag> findAllTag();

    Tag findByNameTag(String name);

}
