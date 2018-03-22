package ch06_6;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch06.board.NewArticleRequest;
import ch06.board.ReadArticleService;
import ch06.board.WriteArticleService;

public class MainDesignatorTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch06_6/designatorTest.xml");
		WriteArticleService writeSvc = ctx.getBean("writeArticleService", WriteArticleService.class);
		writeSvc.write(new NewArticleRequest("writer", "title", "content"));
		ReadArticleService readSvc = ctx.getBean("readArticleService", ReadArticleService.class);
		System.out.println("-------첫 번째 readSvc.read(1)");
		readSvc.read(1);
		System.out.println("-------두 번째 readSvc.read(1)");
		readSvc.read(1);
		ctx.close();
	}
}
