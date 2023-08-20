package com.abhirupchandra.FinancialFreedom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhirupchandra.FinancialFreedom.model.User;
import com.abhirupchandra.FinancialFreedom.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public User createUser(User user) 
    {
        return userRepository.save(user);
    }
    
    public User findByMobileNumber(String mobileNumber)
    {
    	return userRepository.findByMobileNumber(mobileNumber);
    }

//    public User getUserById(Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException("User not found"));
//    }

//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public void deleteUser(Long userId) {
//        userRepository.deleteById(userId);
//    }
}
