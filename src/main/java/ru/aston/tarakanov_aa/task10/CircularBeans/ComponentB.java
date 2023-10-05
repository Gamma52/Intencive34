package ru.aston.tarakanov_aa.task10.CircularBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class ComponentB {

	private ComponentA componentA;
	
	private String name = "ComponentB";
	
	@Autowired
	public ComponentB(@Lazy ComponentA componentA) {
		this.componentA = componentA;
	}
}
