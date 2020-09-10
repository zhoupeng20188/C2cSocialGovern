package com.zp.reviewer.api;

import java.util.List;

/**
 * 评审员服务对外暴露的服务
 * @Author zp
 * @create 2020/9/10 10:30
 */
public interface ReviewerService {
    List<Long> selectReviewers(Long reportTaskId);

    void finishVote(Long reviewerId, Long reportTaskId);
}
