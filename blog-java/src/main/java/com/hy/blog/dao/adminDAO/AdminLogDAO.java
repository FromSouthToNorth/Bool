package com.hy.blog.dao.adminDAO;

import com.hy.blog.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminLogDAO {

    void saveBog(Log log);

    List<Log> findAllLog();

    Integer deleteById(@Param("id") Long id);

}
