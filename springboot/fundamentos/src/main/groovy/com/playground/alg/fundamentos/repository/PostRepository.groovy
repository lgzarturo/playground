package com.playground.alg.fundamentos.repository

import com.playground.alg.fundamentos.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository extends JpaRepository<Post, Long>{
}
