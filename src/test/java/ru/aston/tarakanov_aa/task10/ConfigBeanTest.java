package ru.aston.tarakanov_aa.task10;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans.*;


public class ConfigBeanTest {

	private static AnnotationConfigApplicationContext context;
	
	@BeforeAll
	static void init() {
		context = new AnnotationConfigApplicationContext(
				AppConfig.class);
	}
	
	@AfterAll
	static void destroy() {
		context.close();
	}

	@Test
	void createBeanTest() {
		RockAlbum rc = context.getBean(RockAlbum.class);
		ClassicalAlbum cl = context.getBean(ClassicalAlbum.class);
		System.out.println(rc.getSinger());
		System.out.println(cl.getSinger());
	}
}
