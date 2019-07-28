package com.bbs.service.impl;

import com.bbs.dao.UpvoteDao;
import com.bbs.domain.Upvote;
import com.bbs.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpvoteServiceImpl implements UpvoteService {

    @Autowired
    private UpvoteDao upvoteDao;

    /**
     * 根据用户和帖子ID添加点赞数
     *
     * @param
     */
    @Override
    public void addUpvote(Upvote upvote) {

        String articleId = String.valueOf(upvote.getUpvoteArticleId());

        Upvote upv = upvoteDao.findUpvoteByNameAndArticleId(articleId,upvote.getUpvoteUserName());
        if (upv != null && upv.getIsUpvote() == 1) {//已攒 取消点赞从数据库删除
            upvoteDao.deleteUpvote(upvote);
        }else {                                     //添加点赞数据
            upvote.setIsUpvote(1);
            upvoteDao.addUpvote(upvote);
        }
    }

    /**
     * 根据用户名和帖子ID查询点赞
     *
     * @param
     * @return
     */
    @Override
    public Integer findUpvoteByNameAndArticleId(String articleId ,String userName) {
        Upvote upvote = upvoteDao.findUpvoteByNameAndArticleId(articleId, userName);
        if (upvote !=null && upvote.getIsUpvote() ==1)
            return 1;
        return 0;

    }

    /**
     * 根据贴子ID查询点赞数
     * @param articleId
     * @return
     */
    @Override
    public int countUpvoteById(int articleId) {
        return upvoteDao.countUpvoteById(articleId);
    }


}
