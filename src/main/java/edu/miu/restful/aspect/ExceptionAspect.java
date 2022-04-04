package edu.miu.restful.aspect;


import edu.miu.restful.entity.Exception;
import edu.miu.restful.entity.Users;
import edu.miu.restful.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Aspect
@Component
public class ExceptionAspect {
    @Autowired
    ExceptionService exceptionService;

    // @Pointcut("execution(* *.*.*.*(..))")
    @Pointcut("execution(* edu.miu.restful.*.*.*(..))")
    public void Exception() {


    }

    @AfterThrowing(value = "Exception()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalTime now = LocalTime.now();


        Exception exception = new Exception();
        exception.setOperation(joinPoint.getSignature().getName());
        exception.setDate(new Date());
        exception.setTime(Time.valueOf(now));
        exception.setPrinciple(Users.getLoggedInUser());
        exception.setException(e.getMessage());
        exceptionService.save(exception);

    }
}
