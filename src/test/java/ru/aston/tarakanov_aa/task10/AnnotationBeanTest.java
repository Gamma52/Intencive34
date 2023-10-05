package ru.aston.tarakanov_aa.task10;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.aston.tarakanov_aa.task10.AnnotationDefinitionBeans.*;

public class AnnotationBeanTest {
	
	private static ClassPathXmlApplicationContext context;

	@BeforeAll
	static void init() {
		context = new ClassPathXmlApplicationContext(
				"ru/aston/tarakanov_aa/task10/resources/AnnotationContext.xml");
	}
	
	@AfterAll
	static void destroy() {
		context.close();
	}

	@Test
	void createBeanTest() {
		Box box = context.getBean(Box.class);
		System.out.println(box.getCar().getModel());		
	}
}
