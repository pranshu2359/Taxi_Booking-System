package tech.ps.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.ToString;

@Entity
@ToString
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sn;
	
	@Column(unique=true)
	private String username;
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(int sn, String username, String password) {
		super();
		this.sn = sn;
		this.username = username;
		this.password = password;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSn() {
		return sn;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	
}
