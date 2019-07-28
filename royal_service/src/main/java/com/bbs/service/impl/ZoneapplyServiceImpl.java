package com.bbs.service.impl;

import com.bbs.dao.ZoneDao;
import com.bbs.dao.ZoneapplyDao;
import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneapplyServiceImpl implements ZoneapplyService {

    @Autowired
    private ZoneapplyDao zoneapplyDao;
    @Autowired
    private ZoneDao zoneDao;

    /**
     * 添加版块申请
     * @param zoneapply
     * @return
     */
    @Override
    public boolean addZoneapply(Zoneapply zoneapply) {
        Zone zone = zoneDao.findZoneByName(zoneapply.getUserName());

        if (zone !=null){
            return false;
        }
        zoneapplyDao.aadZoneapply(zoneapply);
        return true;
    }
}
