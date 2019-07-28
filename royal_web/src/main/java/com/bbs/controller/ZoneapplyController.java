package com.bbs.controller;

import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/zoneapply")
public class ZoneapplyController {
    @Autowired
    private ZoneapplyService zoneapplyService;

    @RequestMapping("/addZoneapply.do")
    public boolean addZoneapply( Zoneapply zoneapply){
        zoneapply.setUserName("admin");
        return zoneapplyService.addZoneapply(zoneapply);
    }
}
