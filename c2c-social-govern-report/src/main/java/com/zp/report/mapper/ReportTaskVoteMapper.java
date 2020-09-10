package com.zp.report.mapper;

import com.zp.report.entity.ReportTaskVote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zp
 * @create 2020/9/10 12:29
 */
@Mapper
public interface ReportTaskVoteMapper {
    @Insert("insert into report_task_vote(report_task_id,vote_result)" +
            "values(#{reportTaskId),#{voteResult)")
    void insert(ReportTaskVote reportTaskVote);
}
