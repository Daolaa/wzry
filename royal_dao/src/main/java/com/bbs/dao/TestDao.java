package com.bbs.dao;

import com.bbs.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {

    public User findUser();
}
