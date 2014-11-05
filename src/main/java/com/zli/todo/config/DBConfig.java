package com.zli.todo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableMongoRepositories
@Import(RepositoryRestMvcConfiguration.class)
public class DBConfig extends AbstractMongoConfiguration {

   @Override
   protected String getDatabaseName() {
      return "todo";
   }

   @Override
   public Mongo mongo()
      throws Exception {
      return new MongoClient();
   }
}
