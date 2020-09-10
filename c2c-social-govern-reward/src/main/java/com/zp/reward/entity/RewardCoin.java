package com.zp.reward.entity;

/**
 * @Author zp
 * @create 2020/9/10 14:14
 */
public class RewardCoin {
    /**
     * 奖励金币id
     */
    private Long id;
    /**
     * 评审员id
     */
    private Long reviewerId;
    /**
     * 奖励金币数量
     */
    private Integer coins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }
}
