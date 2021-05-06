package com.zfcraft.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zfcraft.web.model.AppLog;
import com.zfcraft.web.service.AppLogService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Map;

@Slf4j
@RestController

public class LogController {
    @Autowired
    private AppLogService appLogService;
    @Autowired
    private RedisTemplate redisTemplate;
    private final Logger logger = LoggerFactory.getLogger(LogController.class);

    //    @Value("${file.upload.url}")
//    private String uploadFilePath;
//Page<AppEnterpriseUserVo> pageList = PageHelper.offsetPage(pageNo, pageSize, true);
    @RequestMapping("/uploadFile")
    public JSONObject httpUpload() throws IOException {


        JSONObject jsonObject = new JSONObject();


        log.debug("debug1");
        log.info("info1");
        log.error("error1");
        logger.info("info2");
        logger.debug("debug2");
        logger.error("error2");
        jsonObject.put("code", 200);
        jsonObject.put("meg", "上传成功！");
        return jsonObject;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(String queryString, Integer pageSize, Integer pageNum) throws Exception {
//        Map paramMap = new ObjectMapper().readValue(queryString, Map.class);
//        Integer pageSize = paramMap.get("pageSize") != null ? (Integer) paramMap.get("pageSize") : 25;
//        Integer pageNo = paramMap.get("pageStart") != null ? (Integer) paramMap.get("pageStart") : 0;
//        String keyword = (String) paramMap.get("keywordText");
//        String startDate = (String) paramMap.get("startDate");
//        String endDate = (String) paramMap.get("endDate");

        return appLogService.selectAllCount(pageNum, pageSize);
    }

    @RequestMapping("/insertAll")
    public Object selectAll(String queryString, String pushParam) throws Exception {
        for (int i = 0; i < 10; i++) {
            appLogService.insertAllCount(i, i);
        }
        return true;
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody AppLog appLog) throws Exception {
//        Map paramMap = new ObjectMapper().readValue(queryString, Map.class);
//        Integer pageSize = paramMap.get("pageSize") != null ? (Integer) paramMap.get("pageSize") : 25;
//        Integer pageNo = paramMap.get("pageStart") != null ? (Integer) paramMap.get("pageStart") : 0;
//        String keyword = (String) paramMap.get("keywordText");
//        String startDate = (String) paramMap.get("startDate");
//        String endDate = (String) paramMap.get("endDate");
        String key="";
        Object mobileCode = redisTemplate.opsForValue().get(key);
        // 获取key过期时间
//        Long keyExpire = redisTemplate.getExpire(key);

      appLogService.delete(appLog);
    }


}


