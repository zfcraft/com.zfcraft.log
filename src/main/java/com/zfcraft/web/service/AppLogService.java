package com.zfcraft.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zfcraft.web.dao.AppLogMapper;
import com.zfcraft.web.dao.LogMapper;
import com.zfcraft.web.model.AppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppLogService {
    @Resource
    private LogMapper appLogMapper;

    public PageInfo<AppLog> selectAllCount(Integer pageNum, Integer pageSize) {
//        startDate = StringUtil.isNotEmpty(startDate) ? (startDate + " 00:00:00") : "";
//        endDate = StringUtil.isNotEmpty(endDate) ? (endDate + " 23:59:59") : "";

//        Page<AppLog> pageList = PageHelper.offsetPage(pageNo, pageSize, true);

        PageHelper.startPage(pageNum, pageSize);
        List<AppLog> pageList = appLogMapper.selectAllCount();
        PageInfo<AppLog> pageInfo = new PageInfo(pageList);

        return pageInfo;

    }

    public void insertAllCount(int i, int i1) {
        appLogMapper.insertAllCount(i, i1);

    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(AppLog appLog) {
        int a=9;
        appLogMapper.delete(appLog);
    }
}
