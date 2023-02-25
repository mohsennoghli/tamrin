package com.isc.tamrin.service;

import com.isc.tamrin.model.Users;

import java.util.List;

public interface IUservice {

    Long createUser(Users users);

    Users getUserById(Long userId);

    List<Users> getAllUsers();

    Users updateUser(Users users);

    void deleteUser(Long userId);
}
