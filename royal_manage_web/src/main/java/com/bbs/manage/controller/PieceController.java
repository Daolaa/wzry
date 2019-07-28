package com.bbs.manage.controller;

import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.PieceService;
import com.bbs.service.ZoneService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/zoneApply")
public class PieceController {
    @Autowired
    private PieceService pieceService;
    @Autowired
    private ZoneService zoneService;

//    /**
//     * 添加新板块
//     * @param zoneapply
//     * @return
//     */
//    @RequestMapping("/savePiece.do")
//    public String savePiece(Zoneapply zoneapply){
//        pieceService.save(zoneapply);
//        return "redirect:findByZoneapp.do";
//    }

    /**
     * 查询申请版块
     * @return
     */
    @RequestMapping("/findByZoneapp.do")
    public ModelAndView findAll(Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum = 1;
        }
        if(pageSize==null){
            pageSize = 5;
        }
        List<Zoneapply> zoneapp = pieceService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(zoneapp);
        ModelAndView mv = new ModelAndView();
        mv.addObject("zoneapplist",pageInfo);
        mv.setViewName("section");
        return mv;
    }

    /**
     * 同意申请添加版块到交流区
     * @param zoneName
     * @param isDef
     * @return
     */
    @RequestMapping("/saveZone2.do")
    public ModelAndView saveZone2(String zoneName,Integer isDef,String id,Integer pageNum,Integer pageSize){
//        Zoneapply zoneapply = pieceService.findById(id);
        zoneService.saveZone(zoneName,isDef,id);
//        List<Zoneapply> pieces = pieceService.findAll();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("zoneapplist",pieces);
//        mv.setViewName("section");
        return findAll(pageNum,pageSize);
//        return "redirect:findByZoneapp.do";
    }

    /**
     * 更改处理状态
     * @param id
     * @return
     */
    @RequestMapping("/updatestatus.do")
    public ModelAndView updatestatus(Integer id,Integer pageNum,Integer pageSize){
        pieceService.updatestatus(id);
        return findAll(pageNum,pageSize);
    }
}
