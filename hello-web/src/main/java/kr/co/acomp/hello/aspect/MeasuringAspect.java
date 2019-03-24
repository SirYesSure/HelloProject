package kr.co.acomp.hello.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MeasuringAspect {

	@Around("execution(* kr.co.acomp.hello.service.*Service.*(..))")
	public Object measuringMethodRunningTime(
			ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		try {
			return joinPoint.proceed();
		} finally {
			long result = System.currentTimeMillis() - start;
			String targetMethodName = joinPoint.getSignature().getName();
			
			System.out.println(targetMethodName + " running time is : " + result);
		}
		
	}
	
}
