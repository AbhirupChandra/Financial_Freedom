package com.abhirupchandra.FinancialFreedom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        // Validate userDto and handle any validation errors
        // Map the UserDto to a User entity object
        User user = mapUserDtoToEntity(userDto);
        // Invoke the service method to add the user
        userService.addUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    // Other controller methods for user-related operations
}
