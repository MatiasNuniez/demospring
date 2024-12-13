package com.matiasnuniez.DemoSpring.repository;

import com.matiasnuniez.DemoSpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
