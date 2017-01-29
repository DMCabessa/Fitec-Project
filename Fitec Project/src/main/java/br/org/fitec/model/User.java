package br.org.fitec.model;

import javax.persistence.*;

@Entity
@Table(name="_user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String login;
	private String name;
	private boolean admin;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
