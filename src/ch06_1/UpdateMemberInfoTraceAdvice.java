package ch06_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import ch06.member.UpdateInfo;

public class UpdateMemberInfoTraceAdvice {
	public void traceReturn(String memberId, UpdateInfo info) {
		System.out.printf("[TA===] 정보수정 : 대상회원 =%s, 수정정보=%s\n", memberId, info);
		
	}
}
