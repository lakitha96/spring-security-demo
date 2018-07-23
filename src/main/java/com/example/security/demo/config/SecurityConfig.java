package com.example.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author lakitha
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("devUser").password("{noop}dev").authorities("ROLE_USER").and()
                .withUser("admin").password("{noop}admin").authorities("ROLE_ADMIN").and();
    }

    //Authorization---


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/protectedByUserRole*").hasRole("USER")
            .antMatchers("/protectedByAdminRole*").hasRole("ADMIN")
            .antMatchers("/", "/notProtected").permitAll()
            .and()
            .httpBasic();
    }
}
