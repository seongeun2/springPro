package ch06_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import ch06.member.UpdateInfo;

public class UpdateMemberInfoTraceAdvice {
	public void traceReturn(String memberId, UpdateInfo info) {
		System.out.printf("[TA===] �������� : ���ȸ�� =%s, ��������=%s\n", memberId, info);
		
	}
}
