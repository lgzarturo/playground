package com.alg.springweb.friend.service;

import com.alg.springweb.friend.domain.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendService extends CrudRepository<Friend, Long> {
}
