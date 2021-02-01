package com.alg.springweb.person.domain;

import com.alg.springweb.friend.domain.Friend;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "people")
public class Person {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private final Long id = null;
	@NonNull
	private String name;
	@JsonBackReference // prevent infinity loop
	@ManyToOne
	private Friend friend;  // only in back reference
}
