package com.example.sqlwebdemo.Repositories;

import com.example.sqlwebdemo.Models.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Long> {

    List<Friend> findAllByFirstNameAndLastName(String firstName, String lastName);
    List<Friend> getByTelephone(String telephone);
}
