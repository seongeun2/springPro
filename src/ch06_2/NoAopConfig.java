package ch06_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch06.member.MemberService;
import ch06.member.MemberServiceImpl;

@Configuration
public class NoAopConfig {
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl();
	}
}
