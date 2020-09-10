package com.zp.report.mapper;

import com.zp.report.entity.ReportTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author zp
 * @create 2020/9/10 10:52
 */
@Mapper
public interface ReportMapper {
    @Insert("insert into report_task(type, report_user_id report_content, target_id, vote_result) " +
            "values(#{type},#{reportUserId},#{reportContent},#{targetId}, #{voteResult})")
    // 为了能拿到主键
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void insert(ReportTask reportTask);

    @Select("select * from report_task")
    List<ReportTask> queryAll();


    @Update("update report_task " +
            "set vote_result = #{voteResult}" +
            "where id = #{id}")
    void updateVoteResult(ReportTask reportTask);

}
