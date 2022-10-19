package com.idat.SetiembreIIIE.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if( "usuario".equals(username)) {
            return new User("usuario", "123", new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("Usuario no existe " + username);
        }
    }
}
