package com.example.springjpaexample.configuration;

import com.example.springjpaexample.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public SecurityConfig(@Qualifier("customUserDetailsService")UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers(HttpMethod.DELETE).hasAuthority(User.RoleType.ROLE_ADMIN.name())
                .antMatchers("/user").permitAll()
                .antMatchers("/mvc/user/userlist").authenticated()
                .antMatchers("/mvc/user/edit/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password("$2a$10$UST67Fo2ev1p1g2H2rL7seHSI4PmBqDPDVc9C452iltZXHv5Wbe/u").roles("USER")
//                //.withUser("user1").password("{noop}rr1").roles("USER")
//                .and()
//                .withUser("admn1").password("$2a$10$LRAqRMIK6QqBAqPijuAiRuFiPuGM682yFs8x6ESrFaTzR2UOG3oL6").roles("ADMIN");
        auth.userDetailsService(userDetailsService);
    }
}
