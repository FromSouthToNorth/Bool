package com.hy.blog.api;

import com.hy.blog.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetaAPI {

    @Autowired
    private MetaService metaService;

    @GetMapping("/getVisitTotal")
    public Long getVisitTotal() {
        return metaService.findVisitTotal();
    }

    @GetMapping("/addVisit")
    public void addVisitNum() {
        metaService.updateVisitTotal(metaService.findVisitTotal() + 1);
    }

}
