package com.bbs.service;

import com.bbs.domain.Upvote;

public interface UpvoteService {

    /**
     * 根据用户和帖子ID添加点赞数
     * @param
     */
    void addUpvote(Upvote upvote);

    public Integer findUpvoteByNameAndArticleId(String articleId ,String userName);

    int countUpvoteById(int articleId);
}
