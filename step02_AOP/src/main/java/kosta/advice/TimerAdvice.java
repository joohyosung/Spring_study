package kosta.advice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * 공통기능 (부가기능)
 * : 사전, 사후 처리 -> around 방식
 */
public class TimerAdvice {
    /**
     * 기능
     * : 사전 - 현재 시간을 구한다.
     * : 사후 - 현재 시간을 구해서 사전과의 차이를 계산한다.
     * @return
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("[LOG] " + methodName + " 호출되기 전 입니다.");

        Object[] params = proceedingJoinPoint.getArgs();
        for(Object param : params){
            System.out.println(param);
        }
        StopWatch sw = new StopWatch();
        sw.start();

        Object obj = proceedingJoinPoint.proceed();

        // 사후처리
        sw.stop();
        System.out.println("[LOG] " + methodName + " 호출된 후 입니다.");
        System.out.println("[LOG] " + methodName + " 실행시간(ms) " + sw.getTotalTimeMillis());
        System.out.println("[LOG] " + methodName + " 리턴값: " + obj);

        return obj;
    }
}
