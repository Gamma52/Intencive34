package ru.aston.tarakanov_aa.task9.SingleTable;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class SportCar extends Car{
	
	@Convert(converter = PilotNameConvector.class)
	@Column(name = "pilot_name")
	private PilotName pilotName;
	
	public SportCar(String name, int power, PilotName pilotName) {
		super(name, power);
		this.pilotName = pilotName;
	}
}
