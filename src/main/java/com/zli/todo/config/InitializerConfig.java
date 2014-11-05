package com.zli.todo.config;

import com.zli.todo.initializer.UserInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializerConfig {

   @Autowired
   private ServiceConfig serviceConfig;

   @Bean
   public UserInitializer userInitializer() {
      return new UserInitializer(serviceConfig.userService());
   }
}
