package com.isc.tamrin.service.impl;

import ch.qos.logback.classic.Logger;
import com.isc.tamrin.dao.IUserRepository;
import com.isc.tamrin.model.Users;
import com.isc.tamrin.service.IUservice;
import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author MOHSEN NOGHLI
 */
@Service
@AllArgsConstructor
public class UserService implements IUservice {


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
