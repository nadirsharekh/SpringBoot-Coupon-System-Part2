package com.devtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devtech.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findCustomerByEmailAndPassword(String Email, String Password);

	//Customer findCustomerByEmail(String Email);
	
	Customer findCustomerById(int customerId);

}
