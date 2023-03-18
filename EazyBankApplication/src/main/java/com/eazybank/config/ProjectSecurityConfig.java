package com.eazybank.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
/*import org.springframework.boot.autoconfigure.security.servlet.HttpSecurity;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterChain;*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
// configuration class
@Configuration
public class ProjectSecurityConfig {

	/**
	 * Below is the custom security configurations
	 */

	@Bean
	DefaultSecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
		.requestMatchers("/notices", "/contact","/register").permitAll()
		.and().formLogin()
		.and().httpBasic();
		return http.build();

		/**
		 * Configuration to deny all the requests
		 */
//    http.authorizeHttpRequests().anyRequest().denyAll()
//            .and().formLogin()
//            .and().httpBasic();
//    return http.build();

		/**
		 * Configuration to permit all the requests
		 */
//    http.authorizeHttpRequests().anyRequest().permitAll()
//            .and().formLogin()
//            .and().httpBasic();
//    return http.build();

	}

	/**
	 * NoOpPasswordEncoder is not recommended for production usage. Use only for
	 * non-prod.
	 *
	 * @return PasswordEncoder
	 */
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//	 @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

/*	 @Bean public InMemoryUserDetailsManager userDetailsService() {
	  
			/*
			 * Approach 1 where we use withDefaultPasswordEncoder() method while creating
			 * the user details
			 */
	  
	  /* UserDetails admin = User.withDefaultPasswordEncoder() 
	  .username("admin") 
	  .password("12345")
	  .authorities("admin") 
	  .build(); 
	   UserDetails user = User.withDefaultPasswordEncoder() 
	  .username("user") 
	  .password("12345") 
	  .authorities("read")  .build();
	  return new InMemoryUserDetailsManager(admin, user);*/
	  
	  
		/*
		 * Approach 2 where we use NoOpPasswordEncoder Bean while creating the user
		 * details
		 */
	  
//	  UserDetails admin = User.withUsername("admin")
//			  .password("12345")
//	          .authorities("admin") 
//	          .build(); 
//	  UserDetails user = User.withUsername("user")
//	  .password("12345") 
//	  .authorities("read") 
//	  .build();
//	  return new InMemoryUserDetailsManager(admin, user);
//	  } 
	

}
