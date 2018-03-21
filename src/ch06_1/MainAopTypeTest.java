package ch06_1;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch06.member.MemberService;
import ch06.member.UpdateInfo;

public class MainAopTypeTest {
	public static void main(String[] args) {
		/*GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch06_1/aopTypeTest.xml");*/
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch06_1/aopTypeTest2.xml");
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		
		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("ÃÖ¹ü±Õ");
		ms.update("madvirus", updateInfo);
		ctx.close();
	}
}
