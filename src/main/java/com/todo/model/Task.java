package com.todo.model;

public class Task extends ModelBase {
   private String description;
   private boolean complete;

   public Task(long id, String description) {
      super(id);
      this.description = description;
      this.complete = false;
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
