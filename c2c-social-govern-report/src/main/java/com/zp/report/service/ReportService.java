package com.zp.report.service;

import com.zp.report.entity.ReportTask;
import com.zp.report.entity.ReportTaskVote;

import java.util.List;

/**
 * @Author zp
 * @create 2020/9/10 10:56
 */
public interface ReportService {
    void addReportTask(ReportTask reportTask);

    void initVote(List<Long> reviewers, Long reportTaskId);

    List<ReportTask> queryAll();

    void vote(Long reviewId, Long reportTaskId, Integer voteResult);

    Boolean calculateVotes(Long reportTaskId);

    void updateVoteResult(ReportTask reportTask);

    List<ReportTaskVote> queryTaskVoteByTaskId(Long reportTaskId);
}
