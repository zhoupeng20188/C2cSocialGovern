package com.zp.reward.service;

import com.zp.reward.api.RewardService;
import com.zp.reward.entity.RewardCoin;
import com.zp.reward.mapper.RewardCoinMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zp
 * @create 2020/9/10 10:35
 */
@Service(version = "1.0.0",
        interfaceClass = RewardService.class,
        cluster = "failfast",
        loadbalance = "roundrobin")
public class RewardServiceImpl implements RewardService {

    @Resource
    RewardCoinMapper rewardCoinMapper;
    @Override
    public void giveReward(List<Long> reviewers) {
        for (Long reviewer : reviewers) {
            RewardCoin rewardCoin = new RewardCoin();
            rewardCoin.setReviewerId(reviewer);
            rewardCoin.setCoins(5);
            rewardCoinMapper.insert(rewardCoin);
        }
    }
}
