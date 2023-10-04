package ru.aston.tarakanov_aa.task10.PropertyRederBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class PropertyReader {
	
	@Autowired
	private Environment env;
	
	public void dosomething() {
        String username = env.getProperty("myapp.username");
        String email = env.getProperty("myapp.email");

        System.out.println("Username: "+username+", Email: "+email);
    }
	
}
