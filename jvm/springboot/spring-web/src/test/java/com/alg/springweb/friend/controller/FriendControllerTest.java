package com.alg.springweb.friend.controller;

import com.alg.springweb.friend.domain.Friend;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class FriendControllerTest {

    @Autowired
    FriendController friendController;

    @Test
    public void testCreateReadDelete() {
        Friend friend = new Friend("Arturo", "Lopez");
        Friend friendResult = friendController.create(friend);
        Iterable<Friend> friends = friendController.list();
        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName", "Arturo");
        friendController.delete(friendResult.getId());
        Assertions.assertThat(friendController.list()).isEmpty();
    }

}
