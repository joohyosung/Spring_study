package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 사전/사후 공통(부가)기능 담당
 */
@Component // 생성
@Aspect
public class AroundAdvice {
    @Around("PointCutDefinition.log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 사전
        System.out.println("AroundAdvice의 사전 처리 중입니다. \n");

        Object obj = joinPoint.proceed();

        // 사후
        System.out.println("AroundAdvice의 사후 처리 중입니다. \n");

        return obj;
    }
}
