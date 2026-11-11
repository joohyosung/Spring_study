package kosta.advice;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 다양한 포인트컷 정의하는 클래스
 */
public class PointCutDefinition {
    /**
     * 로그에 해당하는 포인트컷
     */
    @Pointcut("execution(* kosta.service.*.*(..))")
    public void log(){}

    /**
     * transaction에 해당하는 포인트컷
     */
    @Pointcut("execution(* kosta.service.*DaoImpl.*(..))")
    public void transactionPonitcut(){}
}
