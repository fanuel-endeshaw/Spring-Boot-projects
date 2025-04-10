package com.jws.jwtdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUsername(String user);

//	User saveAll(User user);

//	User save(User user);
}
