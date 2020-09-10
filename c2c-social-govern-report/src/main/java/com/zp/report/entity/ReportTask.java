package com.zp.report.entity;

/**
 * @Author zp
 * @create 2020/9/10 10:50
 */
public class ReportTask {
    /**
     * 举报id
     */
    private Long id;
    /**
     * 举报类型
     */
    private String type;
    /**
     * 举报人id
     */
    private Long reportUserId;
    /**
     * 举报内容
     */
    private String reportContent;
    /**
     * 举报目标id
     */
    private Long targetId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(Long reportUserId) {
        this.reportUserId = reportUserId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
}
