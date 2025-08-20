//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/", "/welcome", "/css/**", "/js/**").permitAll()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//            )
//            .formLogin(form -> form
//                .loginPage("/admin/login")
//                .defaultSuccessUrl("/admin/dashboard")
//                .failureUrl("/admin/login?error=true")
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .logoutSuccessUrl("/welcome")
//                .permitAll()
//            );
//        return http.build();
//    }
//    
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder()
//            .username("SOA-Iter1")
//            .password(passwordEncoder().encode("Susil@123"))
//            .roles("ADMIN")
//            .build();
//            
//        return new InMemoryUserDetailsManager(admin);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    
//}
//
//
//


package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/welcome", "/css/**", "/js/**").permitAll()
                .requestMatchers("/admin/login").permitAll()
                .requestMatchers("/student/login").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // Student paths will be handled by admin dashboard for now
                .requestMatchers("/student/**").hasRole("ADMIN") // Temporary - students use admin dashboard
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/admin/login") // Keep admin login as primary
                .defaultSuccessUrl("/admin/dashboard") // All logins go to admin dashboard
                .failureUrl("/admin/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/welcome")
                .permitAll()
            );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
            .username("SOA-Iter1")
            .password(passwordEncoder().encode("Susil@123"))
            .roles("ADMIN")
            .build();
            
        // Student user with ADMIN role temporarily
        UserDetails student = User.builder()
            .username("student")
            .password(passwordEncoder().encode("student123"))
            .roles("ADMIN") // Temporary - assign ADMIN role
            .build();
            
        return new InMemoryUserDetailsManager(admin, student);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}