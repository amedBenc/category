package com.bouali.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserCRUDAspect {

	@Before("execution(* UserRepository.findAll(..))") // point-cut expression
	public void logBeforeV1(JoinPoint joinPoint) {
		System.out.println("UserRepository.findAll() : " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* UserRepository.findAll(..))") // point-cut expression
	public void logSuccesJoinPoint(JoinPoint joinPoint) {
		System.out.println("UserRepository.findAll() : " + joinPoint.getSignature().getName());
	}

}