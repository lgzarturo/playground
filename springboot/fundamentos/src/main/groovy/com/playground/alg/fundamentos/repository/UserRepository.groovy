package com.playground.alg.fundamentos.repository

import com.playground.alg.fundamentos.model.User
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmailString(String email)

    @Query("SELECT u FROM User u WHERE u.username LIKE ?1%")
    List<User> findAndSort(String username, Sort sort)

    List<User> findByUsername(String name)
}
