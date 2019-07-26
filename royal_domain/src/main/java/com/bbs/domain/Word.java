package com.bbs.domain;

/*
 * 敏感词实体类:bbs_word_table
 *
 */
public class Word {
    private Integer wordId;
    private String word;//敏感词
    private Integer status;//是否启用

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
