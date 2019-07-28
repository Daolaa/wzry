package com.bbs.controller;

import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/piece")
public class PieceController {
    @Autowired
    private PieceService pieceService;

    /**
     * 添加新板块
     * @param zoneapply
     * @return
     */
    @RequestMapping("/save")
    public String save(Zoneapply zoneapply){
        pieceService.save(zoneapply);
        return "user_piece";
    }
}
