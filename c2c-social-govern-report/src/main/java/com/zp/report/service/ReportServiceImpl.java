package com.zp.report.service;

import com.zp.report.entity.ReportTask;
import com.zp.report.entity.ReportTaskVote;
import com.zp.report.mapper.ReportMapper;
import com.zp.report.mapper.ReportTaskVoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zp
 * @create 2020/9/10 10:58
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    ReportMapper reportMapper;

    @Resource
    ReportTaskVoteMapper reportTaskVoteMapper;

    @Override
    public void addReportTask(ReportTask reportTask) {
        reportMapper.insert(reportTask);
    }

    @Override
    public void initVote(List<Long> reviewers, Long reportTaskId) {
        for (Long reviewer : reviewers) {
            ReportTaskVote reportTaskVote = new ReportTaskVote();
            reportTaskVote.setReportTaskId(reportTaskId);
            reportTaskVote.setReviewerId(reviewer);
            reportTaskVote.setVoteResult(ReportTaskVote.UNKNOWN);
            reportTaskVoteMapper.insert(reportTaskVote);
        }

    }

    @Override
    public List<ReportTask> queryAll() {
        return reportMapper.queryAll();
    }
}
