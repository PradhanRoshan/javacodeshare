package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.backend.model.Customer;
import com.springboot.backend.model.CustomerProduct;
import com.springboot.backend.model.Product;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long>{

	@Query(value="select name from product where id IN "
			+ "(select product_id from customer_product where customer_id=?1)"
			, nativeQuery = true)
	List<String> getProductsByCustomerIdNative(Long id);
	
	@Query("select cp.product.name from CustomerProduct cp where cp.customer.id=?1")
	List<String> getProductsByCustomerId(Long id);

	@Query(value="select * from customer where id IN (select customer_id from customer_product where product_id=?1)"
			, nativeQuery = true)
	List<Object> getCustomersByProductIdNative(Long pid);

	@Query("select cp.customer from CustomerProduct cp where cp.product.id=?1")
	List<Customer> getCustomersByProductId(Long pid);

	@Query("select distinct cp.customer from CustomerProduct cp where cp.product.id IN "
			+ " (select p.id from Product p where LOWER(p.vendor.name)=LOWER(?1))")
	List<Customer> getCustomersByVendorName(String name);
	
	@Query("select distinct cp.customer from CustomerProduct cp where cp.product.vendor.name=?1")
	List<Customer> getCustomersByVendorNameAlternative(String name);
}
