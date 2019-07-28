package com.bbs.dao;

import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneapplyDao {

    /**
     * 添加版块申请
     * @param zoneapply
     * @return
     */
    @Insert("INSERT INTO bbs_zoneapply_table VALUES(#{applyZoneId},#{zoneName},#{userName},#{reason},#{status})")
    void aadZoneapply(Zoneapply zoneapply);

}
