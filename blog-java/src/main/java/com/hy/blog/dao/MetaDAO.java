package com.hy.blog.dao;

import org.apache.ibatis.annotations.Param;

public interface MetaDAO {

    Long findVisitTotal();

    void updateVisitTotal(@Param("visitTotal") Long visitTotal);

}
