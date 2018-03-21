package ch06_3;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch06.board.NewArticleRequest;
import ch06.board.ReadArticleService;
import ch06.board.WriteArticleService;


public class MainQuickStartAll {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch06_4/acQuickStartAll.xml");
		WriteArticleService writeArticleService =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		
		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1);
		readArticleService.read(1);
		ctx.close();
	}
}

