package com.hy.blog.service.adminService;

import com.hy.blog.entity.Comment;

import java.util.List;
import java.util.Map;

public interface AdminCommentService {

    Map<String, List<Comment>> findAllComment();

    Integer findByIdDelete(Long id);

}
