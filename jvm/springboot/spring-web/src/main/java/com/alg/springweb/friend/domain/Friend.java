package com.alg.springweb.friend.domain;

import com.alg.springweb.person.domain.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id = null;
    @JsonProperty("first-name")
    @NotBlank
    private String firstName;
    @JsonProperty("last-name")
    @NotEmpty
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

    public Friend(@NotBlank String firstName, @NotEmpty String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
