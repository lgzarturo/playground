package com.alg.springweb;

import com.alg.springweb.friend.controller.FriendController;
import com.alg.springweb.person.controller.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SpringWebApplicationTests {
	@Autowired
	private FriendController friendController;
	@Autowired
	private PersonController personController;

	@Test
	void contextLoads() {
		Assert.notNull(friendController, "friendController is null");
		Assert.notNull(personController, "personController is null");
	}
}
