package com.codebloom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EMSUpdateSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetails(PasswordEncoder passwordEncoder){
        UserDetails employee = User.withUsername("Akash").password(passwordEncoder()
                .encode("BlackBolt@1993")).roles("EMPLOYEE").build();

        UserDetails hr = User.withUsername("Amit").password(passwordEncoder()
                .encode("BlackBolt@1996")).roles("HR").build();

        UserDetails admin = User.withUsername("Prakhar").password(passwordEncoder()
                .encode("Avengers@1993")).roles("MANAGER","HR").build();

        return new InMemoryUserDetailsManager(employee,hr,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*return  http.authorizeRequests()
                .antMatchers("/nonSecure").permitAll()
                .and().authorizeRequests()
                .antMatchers("/welcome","/text").authenticated()
                .and().httpBasic()
                .and().build();*/

        return  http.csrf().disable().authorizeRequests()
                .antMatchers("/employees/welcome").permitAll()
                .and().authorizeRequests()
                .antMatchers("/employees/**").authenticated()
                .and().httpBasic()
                .and().build();

    }
}
