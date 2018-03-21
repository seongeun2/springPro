package ch06_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch06.member.MemberService;
import ch06.member.MemberServiceImpl;
import ch06.member.UpdateInfo;

public class MainAopType {
	public static void main(String[] args) {
		useNoAop();
		System.out.println("===================");
		useAop();
	}
	private static void useNoAop() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(NoAopConfig.class);
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		System.out.println(ms instanceof MemberService);	 //true
		System.out.println(ms instanceof MemberServiceImpl); //true
		ctx.close();
	}
	private static void useAop() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		System.out.println(ms instanceof MemberService);		//true
		System.out.println(ms instanceof MemberServiceImpl);	//false
		System.out.println(ms.getClass().getName());
		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("ÃÖ¹ü±Õ");
		ms.update("aaaa", updateInfo);
		ctx.close();
	}	
}
