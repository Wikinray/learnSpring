package com.example.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Aspect
public class AopTestConf {

    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{

        try {
            Object[] args=pjp.getArgs();
            System.out.println("调用前后处理 args:"+ Arrays.asList(args));
            Object o=pjp.proceed();
            System.out.println("调用原来后处理:"+ Arrays.asList(args));
            return o;
        }catch (Exception ex){
            throw ex;
        }

    }
}
