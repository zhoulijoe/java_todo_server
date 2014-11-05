package com.zli.todo.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class AuthService implements UserDetailsService {

   private final UserService userService;

   public AuthService(UserService userService) {
      this.userService = userService;
   }

   @Override
   public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
      com.zli.todo.model.User user = userService.getUser(username);

      if (user != null) {
         return new User(user.getId(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
      }

      throw new UsernameNotFoundException("User not found");
   }
}
