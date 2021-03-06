package ch06_4;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch06.board.NewArticleRequest;
import ch06.board.ReadArticleService;
import ch06.board.WriteArticleService;
import ch06.member.MemberRegRequest;
import ch06.member.MemberService;
import ch06.member.UpdateInfo;


public class MainQuickStartAll {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch06_4/acQuickStartAll.xml");
		WriteArticleService writeArticleService =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		System.out.println("===========================");
		
		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1);
		readArticleService.read(1);
		System.out.println("===========================");
		MemberService memberService = ctx.getBean(MemberService.class);
		MemberRegRequest memberRegReq = new MemberRegRequest("id", "name", "pw");
		memberService.regist(memberRegReq);
		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("���̸�");
		memberService.update("madvirus", updateInfo);
		ctx.close();
	}
}

