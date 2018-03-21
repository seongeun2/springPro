package ch06_3;


import org.springframework.context.support.GenericXmlApplicationContext;

import ch06.board.NewArticleRequest;
import ch06.board.ReadArticleService;
import ch06.board.WriteArticleService;
import ch06.board.WriteArticleServiceImpl;
import ch06.member.MemberRegRequest;
import ch06.member.MemberService;
import ch06.member.UpdateInfo;

public class MainQuickStart1 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:chap06_03/acQuickStart1.xml");

		WriteArticleService writeArticleService =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		
		   
		ctx.close();
	}
}
