package com.zli.todo.controller;

import com.zli.todo.model.Task;
import com.zli.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

   @Autowired
   private TaskService taskService;

   @RequestMapping(method = RequestMethod.GET)
   public List<Task> getTasks(@AuthenticationPrincipal User user) {
      return taskService.getTasks(user.getUsername());
   }

}
