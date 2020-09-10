package com.zp.reward.mapper;

import com.zp.reward.entity.RewardCoin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zp
 * @create 2020/9/10 14:16
 */
@Mapper
public interface RewardCoinMapper {
    @Insert("insert into reward_coin(reviewer_id, coins)" +
            "values(#{reviewerId},#{coins})")
    void insert(RewardCoin rewardCoin);
}
