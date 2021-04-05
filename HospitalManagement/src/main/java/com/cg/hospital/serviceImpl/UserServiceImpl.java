package com.cg.hospital.serviceImpl;


import org.springframework.stereotype.Service;

import com.cg.hospital.bean.User;
import com.cg.hospital.repository.UserRepository;
import com.cg.hospital.service.IUserService;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		return userRepository.findById(id);
	}
	@Override	
	public User findByUsername(String username) {
		
		User user=userRepository.findByUsername(username);
		return user;
		
	}
	
	public User saveUser(User newUser) {
		
		User user=userRepository.save(newUser);
		return user;
		
	}

	public User updateUser(int id,User user) {
		
		Optional<User> retrievedUser=userRepository.findById(id);
		if(retrievedUser==null)
			try {
				throw new Exception("User not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		userRepository.save(user);
		return userRepository.findById(id).get();
		
	}
	
	public User deleteUser(int userId) {
		
		Optional<User> retrievedUser=userRepository.findById(userId);
		if(retrievedUser==null)
			try {
				throw new Exception("User not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		userRepository.deleteById(userId);
		return retrievedUser.get();
		
		
		
	}

	

	







//	public void autoLogin(String userName, String password) {
//		
//		UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
//		UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
//		
//		authenticationManager.authenticate(token);
//		
//		if(token.isAuthenticated()) {
//			SecurityContextHolder.getContext().setAuthentication(token);
//		}
//				
//	}


//	@Autowired
//	private AuthenticationManager authenticationManager;
	
//	@Autowired
//	private UserDetailsService userDetailsService;

	
	
	
}
