package com.zli.todo.config;

import com.zli.todo.repository.TaskRepository;
import com.zli.todo.repository.UserRepository;
import com.zli.todo.service.AuthService;
import com.zli.todo.service.TaskService;
import com.zli.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class ServiceConfig {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private TaskRepository taskRepository;

   @Bean
   public AuthService authService() {
      return new AuthService(userService());
   }

   @Bean
   public UserService userService() {
      return new UserService(userRepository);
   }

   @Bean
   public TaskService taskService() {
      return new TaskService(taskRepository);
   }
}
