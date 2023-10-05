package ru.aston.tarakanov_aa.task10.AnnotationDefinitionBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class Box {	
	
	private Car car;
	
	@Autowired	
	public Box(@Qualifier("robot") Car car) {
		this.car = car;
	}
}
