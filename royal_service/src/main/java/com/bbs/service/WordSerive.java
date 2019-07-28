package com.bbs.service;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface WordSerive {

    /**
     * 查询全部敏感词
     * @return
     */
    List<Word> findAll(Integer pageNum,Integer pageSize);

    /**
     * 添加敏感词
     * @param word
     */
    void saveWord(Word word);

    /**
     * 根据敏感词id修改状态
     * @param word
     */
    void updateStatus(Word word);

    /**
     * 根据敏感词id删除这个敏感词
     * @param wordId
     */
    @Delete("delete from bbs_word_table where wordId = #{wordId}")
    void deleteStatus(Integer wordId);
}
