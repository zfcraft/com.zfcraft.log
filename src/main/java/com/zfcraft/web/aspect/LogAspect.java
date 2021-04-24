package com.zfcraft.web.aspect;

import com.zfcraft.web.annotation.LogAnnotation;
import com.zfcraft.web.model.AppLog;
import com.zfcraft.web.service.AppLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;

/**
 * 菜单访问日志纪录切面
 */
@Aspect
@Component
public class LogAspect {

    private AppLogService appLogService;

    @Autowired
    public LogAspect(AppLogService appLogService) {
        this.appLogService = appLogService;
    }

    @Pointcut("execution(public * com.zfcraft.web.controller.*.*(..))")
    public void addAdvice() {
    }

    @AfterReturning("addAdvice()&& @annotation(logAnnotation)")
    public void operationPro(JoinPoint jp, LogAnnotation logAnnotation) {

        String[] paramterNames = ((CodeSignature) jp.getSignature()).getParameterNames();
        int index = 0;
        for (int i = 0; i < paramterNames.length; i++) {
            if ("openid".equals(paramterNames[i])) {
                index = i;
                break;
            }
        }

//        SysBtnClickLog sysBtnClickLog = new SysBtnClickLog();
//        sysBtnClickLog.setIsDelete(BussinessConstants.DEFAULT.intValue());
//        sysBtnClickLog.setCreatedAt(Calendar.getInstance().getTime());
//        sysBtnClickLog.setMenu(logAnnotation.menueName());
//        sysBtnClickLog.setParentMenu(logAnnotation.parentMenueName());
//        if (jp.getArgs()[0] instanceof HashMap) {
//            sysBtnClickLog.setOpenid(((HashMap) jp.getArgs()[0]).get("openid").toString());
//        } else {
//            sysBtnClickLog.setOpenid(jp.getArgs()[index].toString());
//        }
        AppLog appLog = new AppLog();
//        sysBtnClickLogService.insert(appLog);
    }
}
