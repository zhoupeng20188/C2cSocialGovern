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
}
