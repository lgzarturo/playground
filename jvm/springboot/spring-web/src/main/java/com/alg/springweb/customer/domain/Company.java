package com.alg.springweb.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;
    @Column(unique = true)
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }
}
