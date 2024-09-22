package com.example.springsecurityjwtdemo.dto;

import com.example.springsecurityjwtdemo.model.User;
import com.example.springsecurityjwtdemo.model.status.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));

        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDTO = new AdminUserDto();
        adminUserDTO.setId(user.getId());
        adminUserDTO.setUsername(user.getUsername());
        adminUserDTO.setFirstName(user.getFirstname());
        adminUserDTO.setLastName(user.getLastname());
        adminUserDTO.setEmail(user.getEmail());
        adminUserDTO.setStatus(user.getStatus().name());

        return adminUserDTO;
    }
}
