package com.isc.tamrin.controller;

import com.isc.tamrin.model.Users;
import com.isc.tamrin.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author MOHSEN NOGHLI
 */


@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users users) {
        Users savedUsers = userService.createUser(users);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long userId) {
        Users users = userService.getUserById(userId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Users> updateUser(@PathVariable("id") Long userId,
                                            @RequestBody Users users) {
        users.setId(userId);
        Users updatedUsers = userService.updateUser(users);
        return new ResponseEntity<>(updatedUsers, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
