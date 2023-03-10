package com.ev.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(userBuilder.username("EV").password("EV").roles("Employye"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("Elena").password("Elena").roles("HR"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("Ivan").password("Ivan").roles("HR","Manager"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("Employye","HR","Manager")
        .antMatchers("/hr_info").hasRole("HR")
        .antMatchers("/manager_info/**").hasRole("Manager").and().formLogin().permitAll();

    }
}
