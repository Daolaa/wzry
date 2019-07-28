package com.bbs.service.impl;

import com.bbs.dao.PieceDao;
import com.bbs.domain.Zoneapply;
import com.bbs.service.PieceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceServiceImpl implements PieceService {
    @Autowired
    private PieceDao pieceDao;

    /**
     * 添加新板块
     * @param zoneapply
     */
    @Override
    public void save(Zoneapply zoneapply) {
        pieceDao.save(zoneapply);
    }

    /**
     * 查询申请版块
     * @return
     */
    @Override
    public List<Zoneapply> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pieceDao.findAll();
    }




    /**
     * 更改处理状态
     * @param id
     */
    @Override
    public void updatestatus(Integer id){
        pieceDao.updatestatus(id);
    }

    /**
     * 根据ID查询申请版块
     * @param id
     */
    @Override
    public Zoneapply findById(String id) {
        return pieceDao.findById(Integer.parseInt(id));
    }
}
