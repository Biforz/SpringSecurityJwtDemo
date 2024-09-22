package com.example.springsecurityjwtdemo.repository;

import com.example.springsecurityjwtdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
