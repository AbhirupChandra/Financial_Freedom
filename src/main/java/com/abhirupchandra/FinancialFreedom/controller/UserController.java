package com.abhirupchandra.FinancialFreedom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhirupchandra.FinancialFreedom.model.User;
import com.abhirupchandra.FinancialFreedom.repository.UserRepository;
import com.abhirupchandra.FinancialFreedom.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService userService;


	@Autowired
	private PasswordEncoder passwordEnc;
	
    @PostMapping(value="/signup")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
    	try 
    	{
    		User userObject = userService.findByMobileNumber(user.getMobileNumber());
    		if (userObject == null)
    		{
    			String encodedPassword = passwordEnc.encode(user.getPassword());
    			user.setEncodedPassword(encodedPassword);
    			userService.createUser(user);
    		}
    		else
    		{
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Mobile number already exists, Please log in");
    		}
            
            return ResponseEntity.ok("User created successfully");
    	}
    	catch(Exception e) 
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("An error occurred during processing: " + e.getMessage());
    	}
    }

    // Other controller methods for user-related operations
}
