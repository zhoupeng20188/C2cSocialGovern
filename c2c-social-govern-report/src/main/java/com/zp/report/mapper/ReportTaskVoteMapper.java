package com.zp.report.mapper;

import com.zp.report.entity.ReportTaskVote;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author zp
 * @create 2020/9/10 12:29
 */
@Mapper
public interface ReportTaskVoteMapper {
    @Insert("insert into report_task_vote(report_task_id,reviewer_id,vote_result)" +
            "values(#{reportTaskId),#{reviewer_id},#{voteResult)")
    void insert(ReportTaskVote reportTaskVote);

    @Update("update report_task_vote set vote_result = #{voteResult)" +
            "where report_task_id = #{reportTaskId)" +
            "and reviewer_id = #{reviewerId}")
    void update(ReportTaskVote reportTaskVote);

    @Select("select * from report_task_vote" +
            "where report_task_id = #{id}")
    List<ReportTaskVote> selectByReportTaskId(Long id);
}
