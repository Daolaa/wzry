package com.bbs.service.impl;

import com.bbs.dao.WordDao;
import com.bbs.domain.Word;
import com.bbs.service.WordSerive;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordSeriveImpl implements WordSerive {

    @Autowired
    private WordDao wordDao;

    @Override
    public List<Word> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return wordDao.findAll();
    }

    @Override
    public void saveWord(Word word) {
        wordDao.saveWord(word);
    }

    @Override
    public void updateStatus(Word word) {
        wordDao.updateStatus(word);
    }

    @Override
    public void deleteStatus(Integer wordId) {
        wordDao.deleteStatus(wordId);
    }
}
