package com.bbs.controller;

import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/zoneapply")
public class ZoneapplyController {
    @Autowired
    private ZoneapplyService zoneapplyService;

    @RequestMapping("/addZoneapply.do")
    @ResponseBody
    public boolean addZoneapply( Zoneapply zoneapply){
        return zoneapplyService.addZoneapply(zoneapply);
    }
}
