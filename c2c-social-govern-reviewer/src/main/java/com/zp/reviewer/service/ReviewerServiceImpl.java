package com.zp.reviewer.service;

import com.zp.reviewer.api.ReviewerService;
import com.zp.reviewer.entity.ReviewerTaskStatus;
import com.zp.reviewer.mapper.ReviewerMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zp
 * @create 2020/9/10 10:33
 */
@Service(version = "1.0.0",
        interfaceClass = ReviewerService.class,
        cluster = "failfast",
        loadbalance = "roundrobin")
public class ReviewerServiceImpl implements ReviewerService {

    @Resource
    ReviewerMapper reviewerMapper;

    /**
     * 选择评审员
     * @param reportTaskId 举报任务id
     * @return 评审员List
     */
    @Override
    public List<Long> selectReviewers(Long reportTaskId){
        System.out.println("模拟选择一批评审员");
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);

        // 将每个评审员要执行的任务存入数据库中
        for (Long id : list) {
            ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
            reviewerTaskStatus.setReviewerId(id);
            reviewerTaskStatus.setReportTaskId(reportTaskId);
            reviewerTaskStatus.setStatus(ReviewerTaskStatus.PROCESSING);
            reviewerMapper.insert(reviewerTaskStatus);
        }
        return list;
    }

    @Override
    public void finishVote(Long reviewerId, Long reportTaskId) {
        ReviewerTaskStatus reviewerTaskStatus = new ReviewerTaskStatus();
        reviewerTaskStatus.setStatus(ReviewerTaskStatus.FINISHED);
        reviewerTaskStatus.setReportTaskId(reportTaskId);
        reviewerTaskStatus.setReviewerId(reviewerId);
        reviewerMapper.update(reviewerTaskStatus);
    }
}
