package com.example.demo.Service;
import com.example.demo.Model.EmployeeEntity;
import com.example.demo.Model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


    @Data
    public class LoggedInUser extends org.springframework.security.core.userdetails.User{
        private User user;

        public LoggedInUser(User user, String username, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
            super(username, password, enabled, enabled, enabled, enabled, authorities);
            this.user = user;
        }

    }
