package ch02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("file:src/ch02/config.xml");
				AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1111");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "11111");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "111111");
		
		try {
			authSvc.authenticate("bkchoi", "1234");
		} catch (UserNotFoundException ex) { }
		authSvc.authenticate("bkchoi", "1234");
		
		//��й�ȣ üũ
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1234");
		authSvc.authenticate("bkchoi", "5678");
		ctx.close();
	}
	
	private static void runAuthAndCatchAuthEx(AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		} catch (AuthException ex) {
		}
	}
}
