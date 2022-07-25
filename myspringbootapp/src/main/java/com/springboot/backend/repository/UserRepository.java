package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long>{

}
