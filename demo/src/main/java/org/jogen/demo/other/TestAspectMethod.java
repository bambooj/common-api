package org.jogen.demo.other;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 测试切面方法
 */
@Component
@Aspect
public class TestAspectMethod {

    @Before(value = "execution(* org.jogen.demo.controller.TestController.*(..))")
    public void beforeAll(){
        System.out.println("before doing ...");
    }

    @After(value = "execution(* org.jogen.demo.controller.TestController.get(..))")
    public void afterDoing(){
        System.out.println("after doing...");
    }

    @Around(value = "execution(* org.jogen.demo.controller.TestController.batchInsert(..))")
    public Object arroundHandleBusiness(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before around doing ...");
        Object rt = joinPoint.proceed();
        joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();

        String[] parameterName = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        System.out.println(Arrays.asList(parameterName));
        System.out.println("after around doing ...");
        return rt;
    }

    @AfterReturning(returning = "obj", value = "execution(* org.jogen.demo.controller.TestController.destroy(..))")
    public void destroy(Object obj){
        System.out.println("destroy 增强开始...");
        System.out.println("正在处理的对象： " + obj);
        System.out.println("记录destroy日志...");
    }
}
