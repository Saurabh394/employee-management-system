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
        UserDetails user = User.withUsername("Akash").password(passwordEncoder()
                .encode("BlackBolt@1993")).roles("USER").build();

        UserDetails admin = User.withUsername("Amit").password(passwordEncoder()
                .encode("BlackBolt@1996")).roles("ADMIN").build();

        UserDetails userAdmin = User.withUsername("Prakhar").password(passwordEncoder()
                .encode("Avengers@1993")).roles("USER","ADMIN").build();

        return new InMemoryUserDetailsManager(user,userAdmin,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http.authorizeRequests()
                .antMatchers("/nonSecure").permitAll()
                .and().authorizeRequests()
                .antMatchers("/welcome","/text").authenticated()
                .and().httpBasic()
                .and().build();

    }
}
