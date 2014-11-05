package com.zli.todo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.zli.todo.repository"})
public class DBConfig extends AbstractMongoConfiguration {

   @Autowired
   private Environment env;

   @Override
   protected String getDatabaseName() {
      return env.getProperty("db.name");
   }

   @Override
   public Mongo mongo()
      throws Exception {
      return new MongoClient(env.getProperty("db.host"));
   }
}
