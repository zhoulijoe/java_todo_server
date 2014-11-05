package com.zli.todo.controller;

import com.zli.todo.model.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {
   private final AtomicLong counter = new AtomicLong();
   private List<Task> mockTasks;

   public TaskController() {
      this.mockTasks = new ArrayList<Task>();

      mockTasks.add(new Task(String.valueOf(counter.incrementAndGet()), "1", "Buy food"));
      mockTasks.add(new Task(String.valueOf(counter.incrementAndGet()), "1", "Pay bill"));
      mockTasks.add(new Task(String.valueOf(counter.incrementAndGet()), "1", "Set alarm"));
   }

   @RequestMapping(value = "/mocktasks", method = RequestMethod.GET)
   public List<Task> getTasks() {
      return this.mockTasks;
   }

}
