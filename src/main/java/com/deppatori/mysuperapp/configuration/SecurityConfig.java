package com.deppatori.mysuperapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 .httpBasic().disable()
	      .csrf().disable()
         .authorizeRequests()
         .antMatchers("/admin/**").hasAnyRole("ADMIN")
//         .antMatchers("/user_list").hasRole("USER")
         .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
             .antMatchers("/","/login","/simpledata","/buku/**",
            		 "/api/v1/produk/**").permitAll()
             .antMatchers("/api/v1/customers/**").permitAll()  
             .antMatchers("/api/v1/purchases/**").permitAll() 
             .antMatchers("/api/v2/purchases/**").permitAll() 
             .antMatchers("/api/v2/produks/**").permitAll() 
             .antMatchers("/test/**").permitAll() 
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
             .cors()
             .and()
             .exceptionHandling().accessDeniedPage("/access-denied");
	}
	
}
