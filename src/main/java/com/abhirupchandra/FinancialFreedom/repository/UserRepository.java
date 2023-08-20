package com.abhirupchandra.FinancialFreedom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhirupchandra.FinancialFreedom.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByMobileNumber(String mobileNumber);

}
