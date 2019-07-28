package com.bbs.service.impl;

import com.bbs.dao.PieceDao;
import com.bbs.dao.ZoneDao;
import com.bbs.domain.Zone;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneDao zoneDao;
    @Autowired
    private PieceDao pieceDao;
    /**
     * 查询所有区域
     * @return
     */
    @Override
    public List<Zone> findAll() {
        return zoneDao.findAll();
    }


    /**
     * 同意申请添加版块到交流区
     * @param zoneName
     * @param isDef
     * @param id
     */
    @Override
    public void saveZone(String zoneName,Integer isDef,String id) {
        zoneDao.saveZone(zoneName,isDef);
        pieceDao.updatestatus(Integer.parseInt(id));
    }

    public void saveZone1(String zoneName,Integer isDef){
        zoneDao.saveZone(zoneName,isDef);

    }
}
