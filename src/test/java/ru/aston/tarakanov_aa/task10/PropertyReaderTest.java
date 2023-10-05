package ru.aston.tarakanov_aa.task10;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.aston.tarakanov_aa.task10.PropertyRederBeans.*;

public class PropertyReaderTest {
	
	private static ClassPathXmlApplicationContext context;

	@BeforeAll
	static void init() {
		context = new ClassPathXmlApplicationContext(
				"ru/aston/tarakanov_aa/task10/resources/PropertyReaderContext.xml");
	}
	
	@AfterAll
	static void destroy() {
		context.close();
	}

	@Test
	void createBeanTest() {
		PropertyReader reader = context.getBean(PropertyReader.class);
		reader.dosomething();		
	}
}
