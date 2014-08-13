package com.zli.todo.dto;

import com.zli.todo.model.Task;

import java.util.List;

public class TasksContainer {

   private List<Task> tasks;

   public TasksContainer(List<Task> tasks) {
      this.tasks = tasks;
   }

   public List<Task> getTasks() {
      return tasks;
   }

   public void setTasks(List<Task> tasks) {
      this.tasks = tasks;
   }
}
