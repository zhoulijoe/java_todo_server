package com.zli.todo.controller;

import com.zli.todo.model.Task;
import com.zli.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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
   public List<Task> getTasks() {
      return taskService.getTasks("53bfa2ac0cf28a0a430bfc7e");
   }

}
