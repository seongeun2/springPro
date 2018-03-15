package ch02.sensor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSensor {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02_4/config-sensor.xml");
		Monitor monitor = ctx.getBean(Monitor.class);
		System.out.println(monitor);
		ctx.close();
	}
}
