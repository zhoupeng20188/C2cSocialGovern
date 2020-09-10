package com.zp.report.controller;


import com.zp.report.entity.ReportTask;
import com.zp.report.service.ReportService;
import com.zp.reviewer.api.ReviewerService;
import com.zp.reward.api.RewardService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/report")
    public String report(ReportTask reportTask){
        reportService.add(reportTask);
        return "success";
    }
}
