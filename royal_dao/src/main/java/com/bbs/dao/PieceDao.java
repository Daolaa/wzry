package com.bbs.dao;

import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceDao {
    /**
     * 添加新版块
     * @param zoneapply
     */
    @Insert("insert into bbs_zoneapply_table(zoneName,userName,reason) values(#{zoneName},#{userName},#{reason})")
    public void save(Zoneapply zoneapply);

    /**
     * 查询申请版块
     * @return
     */
    @Select("select * from bbs_zoneapply_table")
    public List<Zoneapply> findAll();

    /**
     * 更改处理状态
     * @param id
     */
    @Update("update bbs_zoneapply_table set status=1 where applyZoneId=#{id}")
    public void updatestatus(Integer id);

    /**
     * 根据ID查询申请版块
     * @param id
     */
    @Select("select zoneName from bbs_zoneapply_table where applyZoneId=#{id}")
    public Zoneapply findById(Integer id);
}
