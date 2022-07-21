package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.CustomerProduct;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long>{

}
