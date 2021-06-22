package com.crud.hql.controller;

import com.crud.hql.entity.User;
import com.crud.hql.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //CREAT
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUSer(user));
    }

    //Retrieve
    @GetMapping("/{name}")
    public ResponseEntity<List<User>> findByname(@PathVariable String name){
        return ResponseEntity.ok(userService.findByName(name));
    }

    //UPDATE
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.delete(id));
    }
}
