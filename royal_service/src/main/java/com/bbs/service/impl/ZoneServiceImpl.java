package com.bbs.service.impl;

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
    /**
     * 查询所有区域
     * @return
     */
    @Override
    public List<Zone> findAll() {
        return zoneDao.findAll();
    }
}
