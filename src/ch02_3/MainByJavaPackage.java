package ch02_3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch02.AuthenticationService;
import ch02.PasswordChangeService;

public class MainByJavaPackage {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("ch02_3");
		
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		ctx.close();
	}
}
