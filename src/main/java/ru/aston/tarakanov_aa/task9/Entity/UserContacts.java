package ru.aston.tarakanov_aa.task9.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user_contacts")
public class UserContacts {
	
	@Id
    private long id;
	
	@Column(name = "adress", nullable = false)
	private String adress;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "id")
	private User user;
	
	public UserContacts(String adress, User user) {
		this.adress = adress;
		this.user = user;
	}
}
