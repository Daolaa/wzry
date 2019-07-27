package com.bbs.dao;

import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneDao {

    /**
     * 查询所有区域
     * @return
     */
    @Select("select * from bbs_zone_table")
    public List<Zone> findAll();
}
