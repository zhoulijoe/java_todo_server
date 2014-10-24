package com.zli.todo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.zli.todo.repository"})
public class DBConfig extends AbstractMongoConfiguration {

   private String host;

   @Override
   protected String getDatabaseName() {
      return "todo";
   }

   @Override
   public Mongo mongo()
      throws Exception {
      return new MongoClient(host);
   }

   public void setHost(String host) {
      this.host = host;
   }
}
