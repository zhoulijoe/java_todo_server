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

   public Task getTask(String userId, String id) {
      return taskRepository.findByIdAndUserId(id, userId);
   }

   public Task addTask(String userId, Task task) {
      task.setUserId(userId);

      return taskRepository.save(task);
   }

   public void addTasks(List<Task> tasks) {
      taskRepository.save(tasks);
   }

   public void deleteTask(String userId, String id) {
      Task task = this.getTask(userId, id);

      if (task == null) {
         return;
      }

      taskRepository.delete(task);
   }

   public Task updateTask(String userId, String id, Task task) {
      Task oldTask = this.getTask(userId, id);

      if (oldTask == null) {
         return null;
      }

      if (task.getDescription() != null) {
         oldTask.setDescription(task.getDescription());
      }

      oldTask.setComplete(task.isComplete());
      return taskRepository.save(oldTask);
   }
}
