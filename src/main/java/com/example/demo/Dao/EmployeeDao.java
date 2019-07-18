package com.example.demo.Dao;


import com.example.demo.JPAconfig.UserRepository;
import com.example.demo.Model.EmployeeEntity;
import com.example.demo.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDao {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository repository;

    public List<User> getUsers(){
        List<User> users=repository.findAll();
        return users;
    }

    public User getUserById(int id){
        Optional<User> users =repository.findById(id);

       return users.get();
    }

    public User checkLogin (String username, String password){
        User user;
        List<User> users = repository.findAllUserByUsernameAndPassword(username,password);
                if(users.size()==0) {
                    user=null;
                } else{
                    user=users.get(0)  ;
                    System.out.println(user.getUsername()+" "+user.getPassword());
                    }

        return user;
    }

    public User getUserByUsername (String username){
        User user;
        Optional<User> users = repository.findUserByUsername(username);
        return users.get();
    }

    public void save(User user) {
        repository.save(user);
    }
}
