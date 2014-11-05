package com.zli.todo.model;

import org.springframework.data.annotation.Id;

public class ModelBase {

   @Id
   private String id;

   public ModelBase() {

   }

   public ModelBase(String id) {
      this.id = id;
   }

   public String getId() {
      return this.id;
   }

   public void setId(String id) {
      this.id = id;
   }
}
