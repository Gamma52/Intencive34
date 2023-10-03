package ru.aston.tarakanov_aa.task9.SingleTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class ToyCar extends Car{

	@Column(name = "seat")
	private int seat;
	
	public ToyCar(String name, int power, int seat) {
		super(name, power);
		this.seat = seat;
	}
}
