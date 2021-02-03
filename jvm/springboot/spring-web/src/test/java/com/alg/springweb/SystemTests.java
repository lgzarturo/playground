package com.alg.springweb;

import com.alg.springweb.friend.domain.Friend;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class SystemTests {

    @Test
    public void testCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/friends";
        Friend friend = new Friend("Arturo", "López");
        ResponseEntity<Friend> entity = restTemplate.postForEntity(url, friend, Friend.class);
        Friend[] friends = restTemplate.getForObject(url, Friend[].class);
        Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("Arturo");
        restTemplate.delete(url + "/" + Objects.requireNonNull(entity.getBody()).getId());
        Assertions.assertThat(restTemplate.getForObject(url, Friend[].class)).isEmpty();
    }

}
