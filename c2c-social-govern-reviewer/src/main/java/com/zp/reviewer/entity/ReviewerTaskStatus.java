package com.zp.reviewer.entity;

/**
 * @Author zp
 * @create 2020/9/10 12:00
 */
public class ReviewerTaskStatus {

    public static Integer PROCESSING = 0;
    public static Integer FINISHED = 1;

    private Long id;
    /**
     * 评审员id
     */
    private Long reviewerId;
    /**
     * 举报任务id
     */
    private Long reportTaskId;
    /**
     * 投票结果
     */
    private Integer voteResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
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
}
