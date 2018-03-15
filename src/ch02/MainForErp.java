package ch02;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch02.erp.ErpClient;
import ch02.erp.ErpClientFactory;

public class MainForErp {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02_4/config-erp.xml");
		ErpClientFactory factory = ctx.getBean("factory", ErpClientFactory.class);
		ErpClient client = factory.create();
		System.out.println("==============");
		client.connect();
		client.close();
		System.out.println("==============");
		ctx.close();
	}
}
