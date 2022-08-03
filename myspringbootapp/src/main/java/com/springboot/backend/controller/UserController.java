package com.springboot.backend.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.UserInfoDto;
import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@PostMapping("/user")
	public UserInfo postUser(@RequestBody UserInfo user) {
		UserInfo info = userRepository.getByUsername(user.getUsername());
		if(info != null)
			throw new RuntimeException("Username Invalid!!!");
		
		String password = user.getPassword();
		password = passwordEncoder.encode(password);
		user.setPassword(password);
		return userRepository.save(user);
	}
	
	@GetMapping("/login") //username/password
	public UserInfoDto login(Principal principal) {
		String username = principal.getName();
		UserInfo info = userRepository.getByUsername(username);
		UserInfoDto dto = new UserInfoDto();
		dto.setId(info.getId());
		dto.setName(info.getName());
		dto.setUsername(info.getUsername());
		dto.setRole(info.getRole());
		return dto; 
	}
}

