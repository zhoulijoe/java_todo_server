package com.zli.todo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = {"com.zli.todo.controller"})
@EnableWebMvc
@PropertySource("classpath:/config/application.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

}
