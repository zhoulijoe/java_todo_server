package com.zli.todo.controller;

import com.zli.todo.dto.TasksContainer;
import com.zli.todo.model.Task;
import com.zli.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

   @Autowired
   private TaskService taskService;

   @RequestMapping(method = RequestMethod.GET)
   public TasksContainer getTasks(@AuthenticationPrincipal User user) {
      return new TasksContainer(taskService.getTasks(user.getUsername()));
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Task getTask(@AuthenticationPrincipal User user, @PathVariable String id) {
      Task task = taskService.getTask(user.getUsername(), id);
      return task;
   }

   @RequestMapping(method = RequestMethod.POST)
   public Task addTask(@AuthenticationPrincipal User user, @RequestBody Task task) {
      return taskService.addTask(user.getUsername(), task);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteTask(@AuthenticationPrincipal User user, @PathVariable String id) {
      taskService.deleteTask(user.getUsername(), id);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public Task updateTask(@AuthenticationPrincipal User user, @PathVariable String id, @RequestBody Task task) {
      return taskService.updateTask(user.getUsername(), id, task);
   }
}
