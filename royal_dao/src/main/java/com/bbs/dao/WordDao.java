package com.bbs.dao;


import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordDao {

    /**
     * 查询所有敏感词
     * @return
     */
    @Select("select * from bbs_word_table")
    List<Word> findAll();

    /**
     * 添加敏感词
     * @param words
     */
    @Insert("INSERT  INTO bbs_word_table ( word, STATUS) VALUES (#{word},#{status})")
    void saveWord(Word words);

    /**
     * 根据敏感词id查询
     * @param wordId
     * @return
     */
    @Select("select * from bbs_word_table where wordId = #{wordId}")
    Word findByWordId(Integer wordId);

    /**
     * 根据敏感词id修改这个敏感词状态
     * @param word
     */
    @Update("UPDATE bbs_word_table SET STATUS = #{status} WHERE wordId = #{wordId}")
    void updateStatus(Word word);

    /**
     * 根据敏感词id删除这个敏感词
     * @param wordId
     */
    @Delete("delete from bbs_word_table where wordId = #{wordId}")
    void deleteStatus(Integer wordId);
}
