package ru.aston.tarakanov_aa.task10.XmlBeans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirPlane {
	
	@Value("${airplane.model}")
	private String model;
	
	public void doInit() {
		System.out.println("AirPlane init method");
	}

	public void doDestroy() {
		System.out.println("AirPlane destroy method");
	}
}
