package com.todo.model;

public class Greeting extends ModelBase {
   private final String content;

   public Greeting(long id, String content) {
      super(id);
      this.content = content;
   }

   public String getContent() {
      return content;
   }
}
