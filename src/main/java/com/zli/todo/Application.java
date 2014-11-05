package com.zli.todo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableMongoRepositories
@Import(RepositoryRestMvcConfiguration.class)
public class Application extends SpringBootServletInitializer {

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return configureAppBuilder(application);
   }

   public static void main(String[] args) {
      SpringApplicationBuilder appBuilder = new SpringApplicationBuilder();

      configureAppBuilder(appBuilder).application();

      appBuilder.run(args);
   }

   private static SpringApplicationBuilder configureAppBuilder(SpringApplicationBuilder application) {
      return application.sources(Application.class)
                        .showBanner(false)
                        .web(true);
   }
}
