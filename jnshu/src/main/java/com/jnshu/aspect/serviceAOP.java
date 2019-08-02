package com.jnshu.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class serviceAOP {
    @Pointcut("execution(* com.jnshu.service..*Impl.*(..))")
    public void serviceAspect(){}

    @Around(value = "serviceAspect()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Logger logger = LogManager.getLogger(pjp.getTarget());
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();

        logger.info("start active:{}{} method",className,methodName);

        long startTime = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long endTime = System.currentTimeMillis();

        logger.info("return:{}，excution time:{}ms",obj,endTime-startTime);

        return obj;
    }
}
