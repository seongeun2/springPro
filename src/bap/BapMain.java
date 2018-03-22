package bap;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BapMain {
	public static void main(String[] args) {
		String meal = "점심";		//아침, 점심, 저녁
		String kind = "파스타";	//음식 종류
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("bap/bap.xml");
		Bap bap = ctx.getBean("bap", Bap.class);
		bap.eat(meal, kind);
		ctx.close();
	}
}
