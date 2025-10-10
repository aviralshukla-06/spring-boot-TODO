package com.aviral.myFirstDocumentation.repository;

import com.aviral.myFirstDocumentation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
