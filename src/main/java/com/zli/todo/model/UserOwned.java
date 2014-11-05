package com.zli.todo.model;

public class UserOwned extends ModelBase {

   private String userId;

   public UserOwned() {
      super();
   }

   public UserOwned(String userId) {
      this.userId = userId;
   }

   public UserOwned(String id, String userId) {
      super(id);
      this.userId = userId;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }
}
