package com.zli.todo.config;

import com.zli.todo.converter.JacksonWithContentLengthConverter;
import com.zli.todo.resolver.JsonViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.zli.todo.controller"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      converters.add(getJacksonWithContentLengthConverter());
   }

   @Bean
   public JacksonWithContentLengthConverter getJacksonWithContentLengthConverter() {
      return new JacksonWithContentLengthConverter();
   }

   @Bean
   public ViewResolver getJsonViewResolver() {
      return new JsonViewResolver();
   }

}
