package com.zp.report.mapper;

import com.zp.report.entity.ReportTask;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zp
 * @create 2020/9/10 10:52
 */
@Mapper
public interface ReportMapper {
    @Insert("insert into report_task(type, report_user_id, report_content, target_id) " +
            "values(#{type},#{reportUserId},#{reportContent},#{targetId})")
    void insert(ReportTask reportTask);
}
