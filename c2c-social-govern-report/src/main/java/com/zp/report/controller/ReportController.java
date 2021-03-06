package com.zp.report.controller;


import com.zp.report.entity.ReportTask;
import com.zp.report.entity.ReportTaskVote;
import com.zp.report.service.ReportService;
import com.zp.reviewer.api.ReviewerService;
import com.zp.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zp
 * @create 2020/9/10 10:38
 */
@RestController
public class ReportController {

    @Reference(version = "1.0.0",
    interfaceClass = ReviewerService.class,
    cluster = "failfast")
    private ReviewerService reviewerService;

    @Reference(version = "1.0.0",
            interfaceClass = RewardService.class,
            cluster = "failfast")
    private RewardService rewardService;

    @Autowired
    private ReportService reportService;


    /**
     * 举报
     * @param reportTask
     * @return
     */
    @GetMapping("/report")
    public String report(ReportTask reportTask){
        // 新增一个举报任务
        reportService.addReportTask(reportTask);
        // 调用评审员服务，选择评审员
        List<Long> reviewers = reviewerService.selectReviewers(reportTask.getId());
        // 初始化评审员对举报任务的投票
        reportService.initVote(reviewers, reportTask.getId());
        return "success";
    }

    /**
     * 查询所有举报
     * @return
     */
    @GetMapping("/report/query")
    public List<ReportTask> queryReportTask(){
        return reportService.queryAll();
    }

    /**
     * 投票
     * @param reviewerId
     * @param reportTaskId
     * @param voteResult
     * @return
     */
    @GetMapping("/report/vote")
    public String vote(Long reviewerId, Long reportTaskId, Integer voteResult){
        // 投票
        reportService.vote(reviewerId, reportTaskId, voteResult);
        // 通知评审员服务完成投票
        reviewerService.finishVote(reviewerId, reportTaskId);
        // 归票
        Boolean hashFinished = reportService.calculateVotes(reportTaskId);
        if(hashFinished){
            // 得到所有投票人
            List<ReportTaskVote> reportTaskVotes = reportService
                    .queryTaskVoteByTaskId(reportTaskId);
            List<Long> reviewers = new ArrayList<>();
            for (ReportTaskVote reportTaskVote : reportTaskVotes) {
                reviewers.add(reportTaskVote.getReviewerId());

            }
            // 发放奖励
            rewardService.giveReward(reviewers);
        }
        return "success";
    }
}
