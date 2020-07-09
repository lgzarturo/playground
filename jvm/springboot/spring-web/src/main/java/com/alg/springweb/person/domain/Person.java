package com.alg.springweb.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private final String id = UUID.randomUUID().toString();
	private String name;
}
