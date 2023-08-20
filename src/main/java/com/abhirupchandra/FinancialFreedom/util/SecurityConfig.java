package com.abhirupchandra.FinancialFreedom.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/users/signup").permitAll() // Permit registration endpoint
//                .anyRequest().authenticated() // Require authentication for other endpoints
//            .and()
//            .csrf().disable(); // Disable CSRF protection for simplicity (use with caution)
//    }
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/users/signup").permitAll().anyRequest().authenticated().and().csrf().disable();
	}
}
