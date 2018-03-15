package ch02_4;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch02.AuthenticationService;
import ch02.PasswordChangeService;

public class MainByXmlNamespace {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02_4/config-aaa-*.xml");
		
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		authSvc.authenticate("bkchoi", "5678");
		ctx.close();
	}
}
