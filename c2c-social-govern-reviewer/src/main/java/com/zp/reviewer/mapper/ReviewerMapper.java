package com.zp.reviewer.mapper;

import com.zp.reviewer.entity.ReviewerTaskStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author zp
 * @create 2020/9/10 12:06
 */
@Mapper
public interface ReviewerMapper {
    @Insert("insert into reviewer_task_status (reviewer_id, report_task_id, vote_result)" +
            "values(#{reviewerId},#{reportTaskId}, #{voteResult})")
    void insert(ReviewerTaskStatus reviewerTaskStatus);
}
