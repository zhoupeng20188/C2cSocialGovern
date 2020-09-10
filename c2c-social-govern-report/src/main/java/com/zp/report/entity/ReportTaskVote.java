package com.zp.report.entity;

/**
 * @Author zp
 * @create 2020/9/10 12:27
 */
public class ReportTaskVote {

    public static Integer UNKNOWN = -1;
    public static Integer PROCESSING = 0;
    public static Integer FINISHED = 1;

    /**
     * 举报任务投票id
     */
    private Long  id;
    /**
     * 举报任务id
     */
    private Long reportTaskId;
    /**
     * 评审员id
     */
    private Long reviewerId;
    /**
     * 举报任务结果
     */
    private Integer voteResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReportTaskId() {
        return reportTaskId;
    }

    public void setReportTaskId(Long reportTaskId) {
        this.reportTaskId = reportTaskId;
    }

    public Integer getVoteResult() {
        return voteResult;
    }

    public void setVoteResult(Integer voteResult) {
        this.voteResult = voteResult;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }
}
