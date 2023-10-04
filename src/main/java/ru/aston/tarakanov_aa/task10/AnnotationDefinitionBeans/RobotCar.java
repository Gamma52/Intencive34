package ru.aston.tarakanov_aa.task10.AnnotationDefinitionBeans;

import org.springframework.stereotype.Component;

@Component("robot")
public class RobotCar implements Car{
	
	private String model = "Tesla";
	
	@Override
	public String getModel() {		
		return model;
	}

	@Override
	public void setModel(String model) {
		this.model = model;
	}

}
