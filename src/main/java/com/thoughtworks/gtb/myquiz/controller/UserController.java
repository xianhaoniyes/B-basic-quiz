package com.thoughtworks.gtb.myquiz.controller;


import com.thoughtworks.gtb.myquiz.Exception.EducationNotFoundException;
import com.thoughtworks.gtb.myquiz.Exception.NoSuchUserException;
import com.thoughtworks.gtb.myquiz.model.Education;
import com.thoughtworks.gtb.myquiz.model.User;
import com.thoughtworks.gtb.myquiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User putUser(@RequestBody @Valid User user){
        return userService.putUser(user);
    }

    @PostMapping("/{id}/educations")
    public ResponseEntity<Education> putEducation(@PathVariable("id") Long userId, @RequestBody @Valid Education education) throws NoSuchUserException{
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.putEducation(userId,education));

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long userId) throws NoSuchUserException{
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    @GetMapping("/{id}/educations")
    public ResponseEntity<List<Education>> getEducationList(@PathVariable("id") Long userId)
            throws EducationNotFoundException,
            NoSuchUserException {
        return  ResponseEntity.status(HttpStatus.OK).body(userService.getEducationList(userId));
    }



}
