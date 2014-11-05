package com.zli.todo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task extends UserOwned {

   private String description;
   private boolean complete;

   public Task() {
      super();
   }

   public Task(String userId, String description) {
      super(userId);
      this.description = description;
   }

   public Task(String id, String userId, String description) {
      super(id, userId);
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
