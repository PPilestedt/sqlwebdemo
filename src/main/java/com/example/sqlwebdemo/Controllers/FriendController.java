package com.example.sqlwebdemo.Controllers;

import com.example.sqlwebdemo.Models.Friend;
import com.example.sqlwebdemo.Repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/friend")
public class FriendController {

    @Autowired
    FriendRepository friendRepository;

    @RequestMapping(path="/all")
    public Iterable<Friend> getAllFriends(){
        return friendRepository.findAll();
    }

    @RequestMapping(path="/name")
    public Iterable<Friend> getFriendByFirstAndLastName(@RequestParam String firstName, @RequestParam String lastName){
        Iterable<Friend> friendslist = friendRepository.findAllByFirstNameAndLastName(firstName,lastName);
        return friendslist;
    }
    @GetMapping("/add")
    public String addFriend(@RequestParam String firstName, @RequestParam String lastName){
        Friend friend = new Friend();
        friend.setFirstName(firstName);
        friend.setLastName(lastName);
        friendRepository.save(friend);
        return "Added " + firstName + " " + lastName;
    }
}
