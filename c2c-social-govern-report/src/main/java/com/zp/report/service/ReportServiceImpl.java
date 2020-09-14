package com.zp.report.service;

import com.zp.report.entity.ReportTask;
import com.zp.report.entity.ReportTaskVote;
import com.zp.report.mapper.ReportMapper;
import com.zp.report.mapper.ReportTaskVoteMapper;
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
        reportTask.setVoteResult(ReportTask.TASK_UNKNOWN);
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

    @Override
    public void vote(Long reviewId, Long reportTaskId, Integer voteResult) {
        ReportTaskVote reportTaskVote = new ReportTaskVote();
        reportTaskVote.setReviewerId(reviewId);
        reportTaskVote.setReportTaskId(reportTaskId);
        reportTaskVote.setVoteResult(voteResult);
        reportTaskVoteMapper.update(reportTaskVote);
    }

    /**
     * 对举报任务进行归票
     * @param reportTaskId
     * @return true:投票已完成，false:未完成
     */
    @Override
    public Boolean calculateVotes(Long reportTaskId) {
        List<ReportTaskVote> reportTaskVotes = reportTaskVoteMapper.selectByReportTaskId(reportTaskId);
        Integer quorum = reportTaskVotes.size() / 2 + 1;
        System.out.println("quorum = " +quorum);
        Integer approvedVotes = 0;
        Integer unApprovedVotes = 0;

        for (ReportTaskVote reportTaskVote : reportTaskVotes) {
            Integer voteResult = reportTaskVote.getVoteResult();
            if (ReportTaskVote.APPROVED.equals(voteResult)) {
                approvedVotes++;
            } else if (ReportTaskVote.UNAPPROVED.equals(voteResult)) {
                unApprovedVotes++;
            }
        }
        ReportTask reportTask = new ReportTask();

        reportTask.setId(reportTaskId);
        Boolean result = false;
        if (approvedVotes >= quorum) {
            // 大多数赞成
            reportTask.setVoteResult(ReportTask.TASK_APPROVED);
            result = true;
        } else if (unApprovedVotes >= quorum) {
            // 大多数反对
            reportTask.setVoteResult(ReportTask.TASK_UNAPPROVED);
            result = true;
        }
        if(result){
            // 更新整体投票结果
            updateVoteResult(reportTask);
        }

        return result;
    }

    @Override
    public void updateVoteResult(ReportTask reportTask) {
        reportMapper.updateVoteResult(reportTask);
    }

    @Override
    public List<ReportTaskVote> queryTaskVoteByTaskId(Long reportTaskId) {
        return reportTaskVoteMapper.selectByReportTaskId(reportTaskId);
    }
}
