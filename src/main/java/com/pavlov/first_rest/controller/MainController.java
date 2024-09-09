package com.pavlov.first_rest.controller;

import com.pavlov.first_rest.entry.User;
import com.pavlov.first_rest.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {
    private final UserRepo uR;
    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        log.info("Add one new user: {}", uR.save(user));
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return uR.findAll().stream().sorted(Comparator.comparing(User::getId)).toList();
    }
    @GetMapping("{id}")
    public User findUserById(@PathVariable int id) {
        return uR.findById(id).orElseThrow();
    }
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable int id) {
        uR.deleteById(id);
    }

    @PutMapping("{id}")
    public String updateUserById(@PathVariable int id, @RequestBody User user) {
        if (!uR.existsById(id)) {
            return "User not found";
        }
        User u = new User(id, user.getName(), user.getAge());
        return uR.save(u).toString();
    }
}
