package com.alg.springweb.common.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/customers" , "/customers/**").permitAll()
            .antMatchers("/api" , "/api/**").permitAll()
            .antMatchers(HttpMethod.POST, "/api").permitAll()
            .antMatchers(HttpMethod.PUT, "/api/**").permitAll()
            .antMatchers(HttpMethod.PATCH, "/api/**").permitAll()
            .anyRequest().authenticated()
            .and().csrf().disable()
            .formLogin().loginPage("/login").permitAll();
    }
}
