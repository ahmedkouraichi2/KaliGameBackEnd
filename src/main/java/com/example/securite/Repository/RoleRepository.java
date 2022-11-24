package com.example.securite.Repository;

import com.example.securite.model.ERole;
import com.example.securite.model.Role;
import com.example.securite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);

}
