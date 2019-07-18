package com.example.demo.Service;


import com.example.demo.JPAconfig.UserRepository;
import com.example.demo.Model.Authorities;
import com.example.demo.Model.EmployeeEntity;
import com.example.demo.Model.User;
import com.example.demo.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userDetailsDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDetailsDao.findUserByUsername(username).get();//hashlenmish 12345
        if (user != null) {
            Collection<GrantedAuthority> auths = getAuthorityArr(user.getAuthorities());

            LoggedInUser lgU = new LoggedInUser(user, username, user.getPassword(), !user.getBlocked(), auths);

            return lgU;
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }

    public static Collection<GrantedAuthority> getAuthorityArr(Collection<Authorities> authorities) {

        List<GrantedAuthority> authoritiesArr = new ArrayList<>();
        Iterator<Authorities> iter = authorities.iterator();
        int i = 0;
        while (iter.hasNext()) {
            Authorities a = iter.next();
            authoritiesArr.add(new SimpleGrantedAuthority(a.getAuthority()));
            i++;
        }

        return authoritiesArr;
    }
}

