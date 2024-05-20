package com.shinhan.myapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
//@Aspect
public class StopWatchAdvice {

	@Pointcut("within(com.shinhan.myapp.controller.BoardController)")
	public void pointcutTarget() {
	}

	@Around("pointcutTarget()")
	public Object aa(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("******" + jp.getSignature().getName() + "******");
		StopWatch watch = new StopWatch("aa");
		watch.start();

		// �־���
		Object object = jp.proceed();

		System.out.println("*****" + jp.getSignature().getName() + "******");
		watch.stop();
		System.out.println("�ɸ��ð�: " + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		return object;
	}
}
