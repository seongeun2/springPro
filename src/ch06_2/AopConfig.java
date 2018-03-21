package ch06_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ch06.member.MemberService;
import ch06.member.MemberServiceImpl;
import ch06_1.UpdateMemberInfoTraceAdvice;
import ch06_1.UpdateMemberInfoTraceAspect;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
	@Bean
	public UpdateMemberInfoTraceAspect memberInfoTraceAspect() {
		return new UpdateMemberInfoTraceAspect();
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
}
