package com.zli.todo.populator;

import com.zli.todo.model.Task;
import com.zli.todo.model.User;
import com.zli.todo.service.TaskService;
import com.zli.todo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class InitialDataPopulator {

   private final UserService userService;

   private final TaskService taskService;

   public InitialDataPopulator(UserService userService, TaskService taskService) {
      this.userService = userService;
      this.taskService = taskService;
   }

   @PostConstruct
   public void init() {
      User adminUser = userService.getUser("admin");

      if (adminUser == null) {
         adminUser = new User("admin", "admin");
         userService.add(adminUser);
      }

      if (taskService.getTasks(adminUser.getId()).isEmpty()) {
         List<Task> tasks = new ArrayList<>();
         tasks.add(new Task(adminUser.getId(), "Buy milk"));
         tasks.add(new Task(adminUser.getId(), "Fix computer"));

         taskService.addTasks(tasks);
      }
   }
}
