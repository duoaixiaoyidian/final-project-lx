package com.baizhi.Aspect;

import com.baizhi.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

@Configuration
@Aspect
public class LogAspect {
    @Pointcut("@annotation(LogAnnotation)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void log(ProceedingJoinPoint proceedingJoinPoint) {
        /*做日志  什么人 什么时间  做了什么事 事情执行结果  save  queryAll  登陆 注册 */
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        //时间
        Date date = new Date();
        //做了什么事
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String name = annotation.name();
        Boolean flag = false;
        //进入业务层
        try {
            proceedingJoinPoint.proceed();
            flag = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(flag);

    }
}
