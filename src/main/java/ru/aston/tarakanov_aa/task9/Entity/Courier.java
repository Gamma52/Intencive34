package ru.aston.tarakanov_aa.task9.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import ru.aston.tarakanov_aa.task9.Enum.CourierType;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "couriers")
public class Courier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
	
	@Column(name = "product", nullable = false)
    private String name;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "courier_type", nullable = false)
	private CourierType courierType;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="courier_region",
   		joinColumns=  @JoinColumn(name="courier_id", referencedColumnName="id"),
   		inverseJoinColumns= @JoinColumn(name="region_id", referencedColumnName="id"))
    private Set<Region> regions = new HashSet<Region>();
    
    public Courier(String name, CourierType courierType) {
    	this.name = name;
    	this.courierType = courierType;
    }
}
