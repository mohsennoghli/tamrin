package com.isc.tamrin.service.impl;

import com.isc.tamrin.dao.IUserRepository;
import com.isc.tamrin.model.Users;
import com.isc.tamrin.service.IUservice;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author MOHSEN NOGHLI
 */
@Service
@AllArgsConstructor
public class UserService implements IUservice {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private IUserRepository userRepository;

    @Override
    public Long createUser(Users users) {
        return userRepository.save(users).getId();
    }

    @Override
    public Users getUserById(Long userId) {
        Optional<Users> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users updateUser(Users users) {
        Users existingUsers = userRepository.findById(users.getId()).get();
        existingUsers.setFirstName(users.getFirstName());
        existingUsers.setLastName(users.getLastName());
        //existingUser.setEmail(user.getEmail());
        Users updatedUsers = userRepository.save(existingUsers);
        return updatedUsers;
    }

    @Override
    public void deleteUser(Long userId) {


        userRepository.deleteById(userId);
    }
}
