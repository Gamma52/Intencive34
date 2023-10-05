package ru.aston.tarakanov_aa.task10;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.aston.tarakanov_aa.task10.XmlBeans.*;

public class XmlBeanTest {
	
	private static ClassPathXmlApplicationContext context;
	
	@BeforeAll
	static void init() {
		context = new ClassPathXmlApplicationContext(
             "ru/aston/tarakanov_aa/task10/resources/XmlContext.xml");
	}
	
	@AfterAll
	static void destroy() {
		context.close();
	}

	@Test
	void createBeanTest() {
		AirPlane plane = context.getBean(AirPlane.class); // singleton
		Helicopter copter = context.getBean(Helicopter.class); // prototype
		System.out.println(copter.getModel());
		System.out.println(plane.getModel());
		
	}
}
