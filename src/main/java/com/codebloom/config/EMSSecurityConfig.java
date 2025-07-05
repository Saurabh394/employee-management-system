/*
package com.codebloom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class EMSSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Saurabh")
                .password(passwordEncoder().encode("Admin@123")).roles("USER");

        auth.inMemoryAuthentication()
                .withUser("Shweta")
                .password(passwordEncoder().encode("Admin@123456")).roles("ADMIN");

        auth.inMemoryAuthentication()
                .withUser("Ashok")
                .password(passwordEncoder().encode("Admin")).roles("USER","ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/nonSecure").permitAll()
                .and()
                .authorizeRequests().antMatchers("/welcome","/text")
                .authenticated()
                .and().httpBasic();

    }
}
*/
