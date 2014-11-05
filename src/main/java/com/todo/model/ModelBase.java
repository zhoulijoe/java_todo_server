package com.todo.model;

public class ModelBase {
   private final long id;

   public ModelBase(long id) {
      this.id = id;
   }

   public long getId() {
      return this.id;
   }
}
