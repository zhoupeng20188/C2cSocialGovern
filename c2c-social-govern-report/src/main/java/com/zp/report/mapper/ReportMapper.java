package com.zp.report.mapper;

import com.zp.report.entity.ReportTask;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author zp
 * @create 2020/9/10 10:52
 */
@Mapper
public interface ReportMapper {
    @Insert("insert into report_task(type, report_user_id,reviewer_id report_content, target_id) " +
            "values(#{type},#{reportUserId},#{reviewerId),#{reportContent},#{targetId})")
    // 为了能拿到主键
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void insert(ReportTask reportTask);

    @Select("select * from report_task")
    List<ReportTask> queryAll();
}
