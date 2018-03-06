package com.developerhaoz.androidbasis.weiboleaderboardalgorithm;

/**
 * 微博的实体类
 *
 * @author Haoz
 * @date 2018/3/5.
 */
public class Weibo {

    /**
     * 微博的标题
     */
    private String content;
    /**
     * 发布微博的时间
     */
    private long time;
    /**
     * 微博的评论数
     */
    private long commentNum;
    /**
     * 微博的点赞数
     */
    private long likeNum;

    public String getContent() {
        return content;
    }

    public long getCommentNum() {
        return commentNum;
    }

    public long getLikeNum() {
        return likeNum;
    }

    /**
     * 获取微博的热度
     */
    public long getHeat() {
        return getCommentNum() + getLikeNum();
    }
}
