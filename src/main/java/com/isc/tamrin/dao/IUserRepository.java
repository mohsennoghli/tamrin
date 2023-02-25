package com.isc.tamrin.dao;

import com.isc.tamrin.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Long> {

}
