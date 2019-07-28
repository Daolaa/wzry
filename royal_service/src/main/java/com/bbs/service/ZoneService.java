package com.bbs.service;

import com.bbs.domain.Zone;

import java.util.List;

public interface ZoneService {

    public List<Zone> findAll();

    /**
     * 同意申请添加版块到交流区
     * @param zoneName
     * @param id
     */
    public void saveZone(String zoneName,Integer isDef,String id);

    public void saveZone1(String zoneName,Integer isDef);

}
