package com.zp.reward.service;

import com.zp.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author zp
 * @create 2020/9/10 10:35
 */
@Service(version = "1.0.0",
        interfaceClass = RewardService.class,
        cluster = "failfast",
        loadbalance = "roundrobin")
public class RewardServiceImpl implements RewardService {
}
