package com.playground.alg.fundamentos.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    Long id
    @Column(length = 200)
    String description
    @ManyToOne
    User user

    @Override
    String toString() {
        return "Post{" +
            "id=" + id +
            ", description='" + description + '\'' +
            ", user=" + user +
            '}'
    }
}
