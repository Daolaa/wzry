package com.bbs.controller;

import com.bbs.domain.Zone;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;
    /**
     * 查询所有区域
     * @return
     */
    @RequestMapping("/findAll.do")
    public List<Zone> findAll(){
        return zoneService.findAll();
    }
}
