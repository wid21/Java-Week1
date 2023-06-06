package com.example.springbootday25.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.example.springbootday25.Service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity

public class SpringConfiguration {
    private final MyUserDetailsService myUserDetailsService;
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()//prevent threat 1
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//mang session if required
                .and()//to go to other subject
                .authenticationProvider(authenticationProvider())//call the methode
                .authorizeHttpRequests()//any requset have to be authrized
                .requestMatchers(HttpMethod.POST, "/api/v1/auth/register").permitAll()//define the path or the type and the authrization
                .requestMatchers("/api/v1/auth/user","/api/v1/login").hasAuthority("USER")
                .requestMatchers("/api/v1/auth/admin").hasAuthority("ADMIN")//only admin or can use **
                .anyRequest().permitAll()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .deleteCookies("JSESSIONID")//delete cookies
                .invalidateHttpSession(true)//can not reach sesstion
                .and()
                .httpBasic();//stop the chain
        return http.build();//build the chain
    }
}



