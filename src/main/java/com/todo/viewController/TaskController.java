package com.todo.viewController;

import com.todo.model.Task;
import org.springframework.web.bind.annotation.RequestMapping;
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

      mockTasks.add(new Task(counter.incrementAndGet(), "Buy food"));
      mockTasks.add(new Task(counter.incrementAndGet(), "Pay bill"));
      mockTasks.add(new Task(counter.incrementAndGet(), "Set alarm"));
   }

   @RequestMapping("/tasks")
   public List<Task> getTasks() {
      return this.mockTasks;
   }
}
