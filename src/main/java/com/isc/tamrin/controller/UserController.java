package com.isc.tamrin.controller;

import com.isc.tamrin.model.Users;
import com.isc.tamrin.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private UserService userService;

    // build create User REST API
    //http://localhost:8888/api/users/save
    @PostMapping(value = "/save")
    public Long createUser(@RequestBody Users users) {
        return userService.createUser(users);

    }

    // build get user by id REST API
    // http://localhost:8888/api/users/1
    @GetMapping("{id}")
    public Users getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    // Build Get All Users REST API
    // http://localhost:8888/api/users
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();

    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8888/api/users/1
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
        log.info("userId : " + userId + " id delete ");
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
