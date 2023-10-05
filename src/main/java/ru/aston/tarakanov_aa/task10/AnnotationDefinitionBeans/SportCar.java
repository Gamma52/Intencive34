package ru.aston.tarakanov_aa.task10.AnnotationDefinitionBeans;

import org.springframework.stereotype.Component;

@Component("sport")
public class SportCar implements Car{

	private String model = "Ferrari";
	
	@Override
	public String getModel() {		
		return model;
	}

	@Override
	public void setModel(String model) {
		this.model = model;
	}

}
