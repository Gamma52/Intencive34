package ru.aston.tarakanov_aa.task10;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.aston.tarakanov_aa.task10.XmlBeans.Helicopter;
import ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans.Player;
import ru.aston.tarakanov_aa.task10.ConfigDefenitionBeans.RockAlbum;
import ru.aston.tarakanov_aa.task10.XmlBeans.AirPlane;

public class Main {

	public static void main(String[] args) {
		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "ru/aston/tarakanov_aa/task10/resources/applicationContext.xml"
//        );		
//		
//		AirPlane plane = context.getBean(AirPlane.class); // singleton
//		Helicopter copter = context.getBean(Helicopter.class); // prototype
//		System.out.println(copter.getModel());
//		System.out.println(plane.getModel());
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		

		RockAlbum rc = context.getBean(RockAlbum.class);
		System.out.println(rc.getSinger());
		context.close();
	}

}
