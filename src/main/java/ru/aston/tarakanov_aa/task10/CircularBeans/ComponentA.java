package ru.aston.tarakanov_aa.task10.CircularBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ComponentA {

	private ComponentB componentB;
	
	@Autowired
	public ComponentA(@Lazy ComponentB componentB) {
		this.componentB = componentB;
	}
}
