package com.example.springsecurityjwtdemo.rest;

import com.example.springsecurityjwtdemo.dto.UserDto;
import com.example.springsecurityjwtdemo.model.User;
import com.example.springsecurityjwtdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users/")
@RequiredArgsConstructor()
public class UserRestControllerV1 {
    private final UserService userService;

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto userDto = UserDto.fromUser(user);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
