package com.imooc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.imooc.config.datasource.DataSourceContextHolder;

@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("execution(* com.imooc.repository..*.*(..))")
    private void aspect() {

    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();

        if (method.contains("save")) {
            DataSourceContextHolder.setDataSource("masterDataSource");
        } else {
            DataSourceContextHolder.setDataSource("slaveDataSource");
        }

        try {
            return joinPoint.proceed();
        } finally {
            DataSourceContextHolder.clear();
        }

    }

}
