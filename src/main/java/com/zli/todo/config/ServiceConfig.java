package com.zli.todo.config;

import com.zli.todo.repository.UserRepository;
import com.zli.todo.service.AuthService;
import com.zli.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

   @Autowired
   private UserRepository userRepository;

   @Bean
   public AuthService authService() {
      return new AuthService(userRepository);
   }

   @Bean
   public UserService userService() {
      return new UserService(userRepository);
   }
}
