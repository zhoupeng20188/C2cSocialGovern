package com.zp.reviewer.service;

import com.zp.reviewer.api.ReviewerService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author zp
 * @create 2020/9/10 10:33
 */
@Service(version = "1.0.0",
        interfaceClass = ReviewerService.class,
        cluster = "failfast",
        loadbalance = "roundrobin")
public class ReviewerServiceImpl implements ReviewerService {
}
