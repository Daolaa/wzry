package com.bbs.service;

import com.bbs.domain.Zoneapply;
import java.util.List;

public interface PieceService {
    /**
     * 添加新版块
     * @param zoneapply
     */
    public void save(Zoneapply zoneapply);

    /**
     * 查询申请版块
     * @return
     */
    public List<Zoneapply> findAll(Integer pageNum,Integer pageSize);

    /**
     * 更改处理状态
     * @param id
     */
    public void updatestatus(Integer id);

    /**
     * 根据ID查询申请版块
     * @param id
     */
    public Zoneapply findById(String id);
}
