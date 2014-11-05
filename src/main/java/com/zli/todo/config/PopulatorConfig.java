package com.zli.todo.config;

import com.zli.todo.populator.InitialDataPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PopulatorConfig {

   @Autowired
   private ServiceConfig serviceConfig;

   @Bean
   public InitialDataPopulator userInitializer() {
      return new InitialDataPopulator(serviceConfig.userService(), serviceConfig.taskService());
   }
}
