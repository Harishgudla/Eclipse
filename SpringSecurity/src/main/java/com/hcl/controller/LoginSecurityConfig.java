package com.hcl.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{
 @Override
 public void configure(AuthenticationManagerBuilder auth) throws Exception
 {
	 auth.inMemoryAuthentication().withUser("harish").password("kushi").roles("USER");
	 auth.inMemoryAuthentication().withUser("lokesh").password("anudeep").roles("ADMIN");
 }
 @Override
 public void configure(HttpSecurity http) throws Exception{
	 http.authorizeRequests().antMatchers("/Success").hasRole("USER").and().formLogin().loginPage("/loginPage").defaultSuccessUrl("/Success").failureUrl("/loginPage?error").and().logout().logoutSuccessUrl("/loginPage?logout");
	 http.authorizeRequests().antMatchers("/Success").hasRole("ADMIN").and().formLogin().loginPage("/loginPage").defaultSuccessUrl("/Success").failureUrl("/loginPage?error").and().logout().logoutSuccessUrl("/loginPage?logout");
	 http.csrf().disable();
 }
	


}
