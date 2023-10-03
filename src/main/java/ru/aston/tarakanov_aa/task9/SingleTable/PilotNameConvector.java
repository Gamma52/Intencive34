package ru.aston.tarakanov_aa.task9.SingleTable;

import jakarta.persistence.AttributeConverter;

public class PilotNameConvector implements AttributeConverter<PilotName, String>{

	@Override
	public String convertToDatabaseColumn(PilotName attribute) {		
		return attribute.getName()+" "+attribute.getSourName();
	}

	@Override
	public PilotName convertToEntityAttribute(String dbData) {
		String[] s = dbData.split(" ");
		return new PilotName(s[0], s[1]);
	}

}
