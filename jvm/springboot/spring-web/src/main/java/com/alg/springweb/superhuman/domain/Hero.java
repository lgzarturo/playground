package com.alg.springweb.superhuman.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id = null;
    @NonNull
    @NotBlank
    private String name;
    @NonNull
    @NotBlank
    private String alias;
    @OneToMany(mappedBy = "hero")
    private Set<Power> powers;
}
