package com.alg.springweb.friend.controller;

import com.alg.springweb.friend.domain.Friend;
import com.alg.springweb.friend.service.FriendService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FriendController {
    final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/api/friends")
    Iterable<Friend> list() {
        return friendService.findAll();
    }

    @PostMapping("/api/friends")
    Friend create(@RequestBody Friend friend) {
        return friendService.save(friend);
    }

    @GetMapping("/api/friends/{id}")
    Friend read(@PathVariable Long id) {
        return friendService.findById(id).orElse(null);
    }

    @PutMapping("/api/friends")
    Friend update(@RequestBody Friend friend) {
        return friendService.save(friend);
    }

    @DeleteMapping("/api/friends/{id}")
    void delete(@PathVariable Long id) {
        friendService.deleteById(id);
    }

}
