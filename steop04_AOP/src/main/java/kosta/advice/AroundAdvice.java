package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 사전/사후 공통(부가)기능 담당
 */
public class AroundAdvice {
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 사전
        System.out.println("AroundAdvice의 사전 처리 중입니다. \n");

        Object obj = joinPoint.proceed();

        // 사후
        System.out.println("AroundAdvice의 사후 처리 중입니다. \n");

        return obj;
    }
}
