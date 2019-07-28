package com.bbs.dao;

import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 同意申请添加版块到交流区
     * @param zoneName
     * @param isDef
     */
    @Insert("insert into bbs_zone_table(zoneName,isDef) values(#{zoneName},#{isDef})")
    public void saveZone(@Param("zoneName") String zoneName,@Param("isDef") Integer isDef);


    @Select("select zoneName from bbs_zone_table where zoneId = #{id}")
    String findZoneNameById(Integer id);
}
