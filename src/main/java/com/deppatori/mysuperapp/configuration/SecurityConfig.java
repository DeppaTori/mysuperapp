package com.deppatori.mysuperapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtConfig jwtConfig;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 .httpBasic().disable()
	      .csrf().disable()
				 // stateless session : jwt
				 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				 .and()
				 // handle attemp : jwt
				 .exceptionHandling().authenticationEntryPoint((req,res,e)->res.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				 .and()
				 .addFilter(new JwtUserPassAuthFilter(authenticationManager(),jwtConfig))
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
             .antMatchers("/api/v2/customers/**").permitAll()
				 .antMatchers(HttpMethod.GET,jwtConfig.getUri()).permitAll()
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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public JwtConfig jwtConfig(){
		return new JwtConfig();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
}
