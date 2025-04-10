package com.jws.jwtdemo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class RegistrationController {

	@Autowired
	private UserRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authmanager;
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return repo.save(user);
	}
	@PostMapping("/get")
	public String regist(@RequestBody User user) {
Authentication authentication=authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
if(authentication.isAuthenticated()) {
	return jwtService.generateToken(user.getUsername());
}
else
	{
	return "failed";
	}
	}
	
	 @RequestMapping("/user")
     public Collection<User> register(){
//   		  @RequestParam("user") String user) {
//   	if(repo.findByUsername(user)==null) {
//   		return null;
//   	}
//   	return repo.findByUsername(user);
   	return repo.findAll();
   }
	 
	 @RequestMapping("/u")
     public String reg(){
		 return "hello";
	 }
	 
	 
}
