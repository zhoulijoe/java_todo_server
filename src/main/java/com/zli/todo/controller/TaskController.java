package com.zli.todo.controller;

import com.zli.todo.dto.TasksContainer;
import com.zli.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

   @Autowired
   private TaskService taskService;

   @RequestMapping(method = RequestMethod.GET)
   public TasksContainer getTasks(@AuthenticationPrincipal User user) {
      return new TasksContainer(taskService.getTasks(user.getUsername()));
   }

}
