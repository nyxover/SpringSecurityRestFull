package com.example.springsecurityresful.repository;

import com.example.springsecurityresful.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
