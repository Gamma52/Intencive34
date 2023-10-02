package ru.aston.tarakanov_aa.task9.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "regions")
public class Region {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
	
	@Column(name = "name")
	private int name;
	
	@Column(name = "koef")
	private int koef;
	
	@Column(name = "size")
	private int size;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="courier_region",
   		joinColumns=  @JoinColumn(name="region_id", referencedColumnName="id"),
   		inverseJoinColumns= @JoinColumn(name="courier_id", referencedColumnName="id"))
    private Set<Courier> couriers;
}
