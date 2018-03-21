package ch06_3;

import org.aspectj.lang.ProceedingJoinPoint;

public class Profiler {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " ���� ");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		}finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ���� ");
			System.out.println(signatureString + "����ð� : " + (finish - start) + "ms");
		}
	}
}
