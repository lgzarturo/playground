package com.playground.alg.fundamentos.repository

import com.playground.alg.fundamentos.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends JpaRepository<User, Long>{
}
