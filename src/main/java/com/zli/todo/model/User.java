package com.zli.todo.model;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User extends ModelBase {

   @Indexed(unique=true, dropDups=true)
   private String username;

   private String password;

   public User() {
   }

   public User(String username, String password) {
      this.username = username;
      this.password = password;
   }

   public User(String id, String username, String password) {
      super(id);
      this.username = username;
      this.password = password;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
