package com.zp.report.service;

import com.zp.report.entity.ReportTask;
import com.zp.report.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zp
 * @create 2020/9/10 10:58
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    ReportMapper reportMapper;

    @Override
    public void add(ReportTask reportTask) {
        reportMapper.insert(reportTask);
    }
}
