package org.example.spring_boot_shopping_cart_project.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.spring_boot_shopping_cart_project.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@Aspect
@Slf4j
public class AspectConfig {
    @Pointcut("execution(* org.example.spring_boot_shopping_cart_project.service.*.*(..))")
    public void selectPoint() {
        log.info("selectPoint");
    }
    @Before("selectPoint() && args(userModel)")
    public void beforeAdvice(JoinPoint joinPoint, UserModel userModel) {
        log.info("before method sig "+joinPoint.getSignature());
        log.info(userModel.toString());
        log.info("before");
    }

    @After("selectPoint()")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("after " + Calendar.getInstance().getTime() );
    }
}
