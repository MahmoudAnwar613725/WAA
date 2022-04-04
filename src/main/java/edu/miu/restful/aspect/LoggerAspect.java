package edu.miu.restful.aspect;

  import edu.miu.restful.entity.Logger;
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
    @Pointcut("@annotation(miu.edu.demo.aspect.annotation.ExecutionTime)")
    public void logOperation(){

    }
    @Around("logOperation()")
    public void logOperation(ProceedingJoinPoint joinPoint) throws Throwable {// C P
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        Logger loger = new Logger();
        loger.setOperation(joinPoint.getSignature().getName());
        loger.setDate(new Date());
        loger.setTime(executionTime);
        loger.setPrinciple(1);
        logerService.save(loger);

    }





}
