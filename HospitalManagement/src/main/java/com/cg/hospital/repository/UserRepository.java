package com.cg.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.hospital.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);
}
