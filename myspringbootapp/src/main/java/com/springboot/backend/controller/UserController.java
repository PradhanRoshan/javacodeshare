package com.springboot.backend.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.UserDto;
import com.springboot.backend.dto.UserEditDto;
import com.springboot.backend.dto.UserInfoDto;
import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.UserRepository;

@RestController
 public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/user")
	public void postUser(@RequestBody UserDto userDto) {
		 String str = new String(Base64.getDecoder().decode(userDto.getEncodedCredentials())); 
		 String username = str.split("@%")[0];
		 String password = str.split("@%")[1]; //potter123
		 
		 UserInfo info = new UserInfo(); 
		 info.setName(userDto.getName());
		 info.setPassword(passwordEncoder.encode(password));
		 info.setUsername(username);
		 info.setPasswordLastReset(LocalDate.now());
		 info.setSecurityQuestion(userDto.getSecurityQuestion());
		 info.setSecurityAnswer(userDto.getSecurityAnswer());
		 info.setRole(userDto.getRole());

		 userRepository.save(info); 
		 
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
	
	@GetMapping("/user/username")
	public UserEditDto getUserByUsername(Principal principal) {
		UserInfo info = userRepository.getByUsername(principal.getName());
		UserEditDto dto = new UserEditDto(info.getId(), info.getName(), 
				info.getSecurityAnswer(), info.getSecurityQuestion());
		return dto; 
	}
	
	@PutMapping("/user/profile")
	public void profileEdit(Principal pricipal, @RequestBody UserDto dto) {
		String username = pricipal.getName();
		userRepository.updateProfile(username,dto.getName(),
				dto.getSecurityQuestion(), dto.getSecurityAnswer());
	}
	
	@GetMapping("/user/security/info/{username}")
	public UserEditDto getUserInfo(@PathVariable("username") String username) {
		UserInfo info =userRepository.getByUsername(username);
		UserEditDto dto = new UserEditDto(info.getId(), info.getName(), 
				"", info.getSecurityQuestion());
		return dto; 
	}
	
	@GetMapping("/verify-security-answer")
	public void verifySecurityQuestion() {
		
	}
}

