package ru.aston.tarakanov_aa.task10.XmlBeans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Helicopter {
	
	@Value("${Helicopter.model}")
	private String model;
	
	public void doInit() {
		System.out.println("Helicopter init method");
	}

	public void doDestroy() {
		System.out.println("Helicopter destroy method");
	}
}
