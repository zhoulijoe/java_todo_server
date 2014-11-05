package com.zli.todo.initializer;

import com.zli.todo.model.User;
import com.zli.todo.service.UserService;

import javax.annotation.PostConstruct;

public class UserInitializer {

   private UserService userService;

   public UserInitializer(UserService userService) {
      this.userService = userService;
   }

   @PostConstruct
   public void init() {
      User adminUser = new User();
      adminUser.setUsername("admin");
      adminUser.setPassword("admin");
      userService.add(adminUser);
   }
}
