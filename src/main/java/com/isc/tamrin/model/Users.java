package com.isc.tamrin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MOHSEN NOGHLI
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= " FIRST_NAME ")
    private String firstName;
    @Column(name = " LAST_NAME ")
    private String lastName;
   @Column( name = " EMAIL " , nullable = false, unique = true)
    private String email;

}
