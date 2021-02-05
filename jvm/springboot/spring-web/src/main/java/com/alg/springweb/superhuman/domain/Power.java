package com.alg.springweb.superhuman.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id = null;
    @NonNull
    @NotBlank
    private String name;
    private int level;
    @ManyToOne
    private Hero hero;
    @ManyToMany
    private Set<Villain> villains;
}
