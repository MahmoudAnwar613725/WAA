package edu.miu.restful.aspect;

import edu.miu.restful.entity.Logger;
import edu.miu.restful.entity.Users;
import edu.miu.restful.service.LogerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    LogerService logerService;

    @Pointcut("@annotation(edu.miu.restful.aspect.annotation.ExecutionTime)")
    public void logOperation() {

    }

    @Around("logOperation()")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {// C P
        long start = System.currentTimeMillis();
        long executionTime = System.currentTimeMillis() - start;
        Logger loger = new Logger();
        loger.setOperation(joinPoint.getSignature().getName());
        loger.setDatetime(new Date());
        loger.setDuration(executionTime);
        loger.setPrinciple(Users.getLoggedInUser());
        logerService.save(loger);
        return joinPoint.proceed();


    }


}
