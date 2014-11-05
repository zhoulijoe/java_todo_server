package com.zli.todo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import javax.validation.constraints.NotNull;

@Configuration
@EnableMongoRepositories
@Import(RepositoryRestMvcConfiguration.class)
@ConfigurationProperties(prefix="db")
public class DBConfig extends AbstractMongoConfiguration {

   @NotNull
   private String name;

   @Override
   protected String getDatabaseName() {
      return this.name;
   }

   @Override
   public Mongo mongo()
      throws Exception {
      return new MongoClient();
   }

   public void setName(String name) {
      this.name = name;
   }
}
