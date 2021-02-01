package com.alg.springweb.friend.domain;

import com.alg.springweb.person.domain.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id = null;
    @NonNull
    @JsonProperty("first-name")
    private String firstName;
    @NonNull
    @JsonProperty("last-name")
    private String lastName;
    private int age;
    @JsonIgnore
    private boolean married;
    @Embedded
    private Address address;
    // @OneToMany(cascade = CascadeType.ALL) // one way reference
    @JsonBackReference // prevent infinity loop
    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL) // back reference
    List<Person> people;
}
