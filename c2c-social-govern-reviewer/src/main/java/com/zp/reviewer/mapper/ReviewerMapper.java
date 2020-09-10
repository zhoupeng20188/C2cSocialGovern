package com.zp.reviewer.mapper;

import com.zp.reviewer.entity.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @Author zp
 * @create 2020/9/10 12:06
 */
@Mapper
public interface ReviewerMapper {
    @Insert("insert into reviewer_task_status (reviewer_id, report_task_id, status)" +
            "values(#{reviewerId},#{reportTaskId}, #{status})")
    void insert(ReviewerTaskStatus reviewerTaskStatus);

    @Update("update reviewer_task_status " +
            "set status = #{status} " +
            "where reviewer_id = #{reviewerId}" +
            "and report_task_id = #{reportTaskId}")
    void update(ReviewerTaskStatus reviewerTaskStatus);
}
