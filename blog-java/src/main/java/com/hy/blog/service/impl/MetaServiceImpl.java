package com.hy.blog.service.impl;

import com.hy.blog.dao.MetaDAO;
import com.hy.blog.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaDAO metaDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Long findVisitTotal() {
        return metaDAO.findVisitTotal();
    }

    @Override
    public void updateVisitTotal(Long visitTotal) {
        metaDAO.updateVisitTotal(visitTotal);
    }

}
