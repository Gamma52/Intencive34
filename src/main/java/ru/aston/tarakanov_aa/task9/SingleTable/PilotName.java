package ru.aston.tarakanov_aa.task9.SingleTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PilotName {
	
	private String name;
	
	private String sourName;
	
	public PilotName(String name, String sour_name) {
		this.name = name;
		this.sourName = sour_name;
	}
}
