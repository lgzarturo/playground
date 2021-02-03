package com.alg.springweb.friend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class Address {
    @NonNull
    private String street;
    @NonNull
    private String city;
}
