package com.zli.todo.service;

import com.zli.todo.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class AuthService implements UserDetailsService {

   private UserRepository userRepository;

   public AuthService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
      com.zli.todo.model.User user = userRepository.findByUsername(username);

      if (user != null) {
         return new User(username, user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
      }

      throw new UsernameNotFoundException("User not found");
   }
}
