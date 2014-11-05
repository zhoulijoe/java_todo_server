package com.zli.todo.service;

import com.zli.todo.model.Task;
import com.zli.todo.repository.TaskRepository;

import java.util.List;

public class TaskService {

   private final TaskRepository taskRepository;

   public TaskService(TaskRepository taskRepository) {
      this.taskRepository = taskRepository;
   }

   public List<Task> getTasks(String userId) {
      return taskRepository.findByUserId(userId);
   }

   public void addTasks(List<Task> tasks) {
      taskRepository.save(tasks);
   }
}
