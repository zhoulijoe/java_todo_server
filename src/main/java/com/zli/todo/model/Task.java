package com.zli.todo.model;

public class Task extends ModelBase {

   private String description;
   private boolean complete;

   public Task() {
      super();
   }

   public Task(String id, String description) {
      super(id);
      this.description = description;
      this.complete = false;
   }

   @Override
   public String toString() {
      final StringBuffer sb = new StringBuffer("Task{");
      sb.append("description='").append(description).append('\'');
      sb.append(", complete=").append(complete);
      sb.append('}');
      return sb.toString();
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public boolean isComplete() {
      return complete;
   }

   public void setComplete(boolean complete) {
      this.complete = complete;
   }
}
