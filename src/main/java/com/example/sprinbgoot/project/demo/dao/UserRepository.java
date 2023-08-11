package com.example.sprinbgoot.project.demo.dao;

import com.example.sprinbgoot.project.demo.entity.User;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
