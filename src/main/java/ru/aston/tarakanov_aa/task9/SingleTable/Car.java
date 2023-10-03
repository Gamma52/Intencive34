package ru.aston.tarakanov_aa.task9.SingleTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Car {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "power")
	private int power;
	
	public Car(String name, int power) {
		this.name = name;
		this.power = power;
	}
}
