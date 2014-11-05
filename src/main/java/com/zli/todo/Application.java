package com.zli.todo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude={RepositoryRestMvcAutoConfiguration.class})
@EnableConfigurationProperties
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
