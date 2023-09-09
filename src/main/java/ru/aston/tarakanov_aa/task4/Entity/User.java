package ru.aston.tarakanov_aa.task4.Entity;

public class User {
    private long id;
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private long order_id;
    
    public User(String name, String surname, String telephone, String email) {
        this.setName(name);
        this.setSurname(surname);
        this.setTelephone(telephone);
        this.setEmail(email);
    }
    
    public User(long id, String name, String surname, String telephone, String email, long order_id) {
        this.id = id;
        this.setName(name);
        this.setSurname(surname);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.order_id = order_id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getId() {
		return id;
	}  
    
}
