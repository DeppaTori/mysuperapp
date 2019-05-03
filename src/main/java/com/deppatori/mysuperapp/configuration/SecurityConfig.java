package com.deppatori.mysuperapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
         .antMatchers("/admin/**").hasAnyRole("ADMIN")
//         .antMatchers("/user_list").hasRole("USER")
         .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
             .antMatchers("/","/login","/simpledata").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
         .logout()
       //  .logoutSuccessUrl("/login")
             .permitAll()
             .and()
             .exceptionHandling().accessDeniedPage("/access-denied");
	}
	
}
