package bap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch06.board.WriteArticleService;

public class Bap {
	public void eat(String meal, String kind) {
		System.out.println("������ "+meal+"�� "+kind+"��(��)�Խ��ϴ�");
	}
}
