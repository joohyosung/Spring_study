package kosta.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component // 생성
@Aspect
public class SampleAdvice {
    /**
     * 사전처리
     */
    @Before("PointCutDefinition.log()")
    public void before(JoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        Object[] params = joinPoint.getArgs();
        for(Object o : params){
            System.out.println(o);
        }
        System.out.println("SampleAdvice before... method 이름: " + method +"\n");
    }
    /**
     * 사후처리(정상 동작)
     */
    @AfterReturning(pointcut = "PointCutDefinition.log()", returning = "returnObjs")
    public void afterReturning(JoinPoint joinPoint, Object returnObjs) throws Throwable {
        System.out.println(joinPoint.getSignature().getName() + "의 리턴 값: " + returnObjs + "\n");
        System.out.println("타겟 대상 메소드가 정상적으로 실행되었을 때 사후처리입니다. \n");
    }
    /**
     * 사후처리(예외발생했을 때)
     */
    @AfterThrowing(pointcut = "PointCutDefinition.log()", throwing = "e")
    public void afterThrowing(Throwable e) throws Throwable {
        System.out.println("타겟 대상 메소드가 예외가 발생했을 때 사후처리입니다. \n");
        System.out.println("예외정보: " + e + "\n");
    }

    /**
     * 사후처리(정상이든 예외가 발생하든 무조건..)
     */
    @After("PointCutDefinition.log()")
    public void afterFinally(JoinPoint joinPoint) throws Throwable {
        System.out.println("예외발생 여부 상관없이 무조건 실행됩니다. \n");
    }
}
