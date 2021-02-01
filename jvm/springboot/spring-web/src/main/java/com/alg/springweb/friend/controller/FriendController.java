package com.alg.springweb.friend.controller;

import com.alg.springweb.common.ErrorMessage;
import com.alg.springweb.friend.domain.Friend;
import com.alg.springweb.friend.service.FriendService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

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
        if (friend.getFirstName() != null && friend.getLastName() != null) {
            return friendService.save(friend);
        } else {
            throw new ValidationException("friend cannot be created");
        }
    }

    @GetMapping("/api/friends/{id}")
    Friend read(@PathVariable Long id) {
        return friendService.findById(id).orElse(null);
    }

    @PutMapping("/api/friends")
    ResponseEntity<Friend> update(@RequestBody Friend friend) {
        if (friendService.findById(friend.getId()).isPresent()) {
            return new ResponseEntity<>(friendService.save(friend), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(friend, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/friends/{id}")
    void delete(@PathVariable Long id) {
        friendService.deleteById(id);
    }

    @GetMapping("/api/friends/search")
    Iterable<Friend> findByQuery(
            @RequestParam(value = "first", required = false) String firstName,
            @RequestParam(value = "last", required = false) String lastName) {
        if (firstName != null && lastName != null) {
            return friendService.findByFirstNameAndLastName(firstName, lastName);
        } if (firstName != null) {
            return friendService.findByFirstName(firstName);
        } if (lastName != null) {
            return friendService.findByLastName(lastName);
        } else {
            return friendService.findAll();
        }
    }
}
