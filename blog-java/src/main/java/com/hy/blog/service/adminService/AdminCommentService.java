package com.hy.blog.service.adminService;

import com.hy.blog.entity.Comment;
import com.hy.blog.vo.CommentVO;

import java.util.List;
import java.util.Map;

public interface AdminCommentService {

    CommentVO findAllComment();

    Integer findByIdDelete(Long id);

    CommentVO findByBlogIdOne(Long id);

    Long findByParentIdSonId(Long id);

}
