package com.playground.alg.fundamentos.model

import com.fasterxml.jackson.annotation.JsonManagedReference

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import java.time.LocalDate

@Entity
@Table
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    Long id
    @Column(unique = true, length = 64)
    String username
    @Column(unique = true, length = 200)
    String email
    String password
    LocalDate birthDate
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Post> posts = []


    @Override
    String toString() {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", birthDate=" + birthDate +
            '}'
    }
}
