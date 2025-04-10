package com.jws.jwtdemo;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Component
@Entity
@Table(name="users")
public class User {
	@Id
private int id;
private String username;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public User() {

}
public User(int id, String username, String password) {
	
	this.id = id;
	this.username = username;
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
