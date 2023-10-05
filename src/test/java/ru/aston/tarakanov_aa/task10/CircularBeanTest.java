package ru.aston.tarakanov_aa.task10;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.aston.tarakanov_aa.task10.CircularBeans.*;

public class CircularBeanTest {
	
private static ClassPathXmlApplicationContext context;
	
	@BeforeAll
	static void init() {
		context = new ClassPathXmlApplicationContext(
				"ru/aston/tarakanov_aa/task10/resources/CircularContext.xml");
	}
	
	@AfterAll
	static void destroy() {
		context.close();
	}

	@Test
	void createBeanTest() {
		ComponentA componentA = context.getBean(ComponentA.class);
		ComponentB ComponentB = context.getBean(ComponentB.class);
		System.out.println(componentA.getName());
		System.out.println(componentA.getComponentB().getName());		
	}
}
