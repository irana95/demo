package com.example.demo.JPAconfig;


import com.example.demo.Model.EmployeeEntity;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAllUserByUsernameAndPassword(String username, String password);

    Optional<User> findUserByUsername(String username);
}
