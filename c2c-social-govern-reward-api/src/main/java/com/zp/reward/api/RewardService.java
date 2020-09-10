package com.zp.reward.api;

import java.util.List;

/**
 * 奖励服务对外暴露的服务
 * @Author zp
 * @create 2020/9/10 10:32
 */
public interface RewardService {

    void giveReward(List<Long> reviewers);
}
