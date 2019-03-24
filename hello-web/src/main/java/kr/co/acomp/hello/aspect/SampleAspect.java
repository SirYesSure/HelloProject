package kr.co.acomp.hello.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAspect {

	@Before("execution(* kr.co.acomp.hello..*.*(..))") // < 포인트 컷 문법
	public void before(JoinPoint joinPoint) {   // < 어드바이스
		String targetMethodName = 
				joinPoint.getSignature().getName();
		
		System.out.println(targetMethodName + " is invoked..");
		
		
	}
	
}
