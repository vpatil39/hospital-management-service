package com.cg.hospital.service;

import java.util.List;
import java.util.Optional;
import com.cg.hospital.bean.User;


public interface IUserService {

	
	public List<User> findAllUsers() ;

	public Optional<User> findUserById(int id);
	
	public User findByUsername(String username) ;

}
