package com.project.regap.controller;

import com.project.regap.domain.UserDTO;
import com.project.regap.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/api/")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    // URI - /api/users
    @GetMapping(value = "users")
    public ResponseEntity<List<UserDTO>> istAllUsers() {
        List<UserDTO> users = this.userService.listAll();
        return new ResponseEntity<List<UserDTO>>(users,
                HttpStatus.OK);
    }

    // URI - /api/user/id/1
    @GetMapping("user/id/{id}")
    public ResponseEntity<UserDTO> getUserById(
            @PathVariable(name = "id") final Long userId) {
        try {
            final UserDTO user = this.userService.
                    get(userId);
            return new ResponseEntity<UserDTO>
                    (user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserDTO>
                    (HttpStatus.NOT_FOUND);
        }
    }

    // URI - /api/user/save
    @PostMapping(value = "user/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO
                                                user) {
        this.userService.save(user);
        return new ResponseEntity<UserDTO>(user,
                HttpStatus.CREATED);
    }

    // URI - /api/user/delete/id/1
    @DeleteMapping("user/delete/id/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable(name = "id") final Long userId) {

        this.userService.delete(userId);
        return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
    }

}
