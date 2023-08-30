package ru.aston.tarakanov_aa.task1;

public class User {
	
	private int age;
	private String name;
	private String sourName;
	
	public User(int age, String name, String sourName) {
		this.setAge(age);
		this.setName(name);
		this.setSourName(sourName);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSourName() {
		return sourName;
	}

	public void setSourName(String sourName) {
		this.sourName = sourName;
	}
}
