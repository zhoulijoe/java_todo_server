package com.zli.todo.config;

import com.zli.todo.resolver.JsonViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.web.servlet.ViewResolver;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Configuration
   @Order(10)
   @EnableWebMvcSecurity
   public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

      @Autowired
      private UserDetailsService authService;

      @Override
      public void configure(AuthenticationManagerBuilder auth)
         throws Exception {
         auth.userDetailsService(authService);
      }

      @Override
      protected void configure(HttpSecurity http)
         throws Exception {
         http
            .requestMatchers().antMatchers("/task/**")
            .and()
            .authorizeRequests()
            .antMatchers("/task/**").access("hasRole('ROLE_USER')");
      }

      @Override
      @Bean
      public AuthenticationManager authenticationManagerBean()
         throws Exception {
         return super.authenticationManagerBean();
      }
   }

   @Configuration
   @EnableAuthorizationServer
   public static class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

      @Autowired
      @Qualifier("authenticationManagerBean")
      private AuthenticationManager authenticationManager;

      @Override
      public void configure(ClientDetailsServiceConfigurer clients)
         throws Exception {
         clients.inMemory().withClient("todo-client")
                           .secret("secret")
                           .authorizedGrantTypes("password", "refresh_token")
                           .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                           .accessTokenValiditySeconds(86400);
      }

      @Override
      public void configure(AuthorizationServerEndpointsConfigurer endpoints)
         throws Exception {
         endpoints.authenticationManager(this.authenticationManager);
      }

   }

   @Configuration
   @EnableResourceServer
   public static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

      @Override
      public void configure(HttpSecurity http)
         throws Exception {
         http
            .requestMatchers().antMatchers("/task/**")
            .and()
            .authorizeRequests()
            .antMatchers("/task/**").access("#oauth2.hasScope('read')");
      }
   }
}
