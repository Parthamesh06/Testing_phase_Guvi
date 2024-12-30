// package com.example.healthcare.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     // In-Memory Authentication with predefined users (Patient, Doctor, Admin)
//     @Bean
//     public UserDetailsService userDetailsService() {
//         var userDetailsManager = new InMemoryUserDetailsManager();

//         var user1 = User.withUsername("patient")
//                 .password("password")  // Use proper encoding in production
//                 .roles("PATIENT")
//                 .build();

//         var user2 = User.withUsername("doctor")
//                 .password("password")
//                 .roles("DOCTOR")
//                 .build();

//         var user3 = User.withUsername("admin")
//                 .password("adminpassword")
//                 .roles("ADMIN")
//                 .build();

//         userDetailsManager.createUser(user1);
//         userDetailsManager.createUser(user2);
//         userDetailsManager.createUser(user3);

//         return userDetailsManager;
//     }

//     // For simple password encoder (for development purposes only, use bcrypt in production)
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return NoOpPasswordEncoder.getInstance();
//     }

//     // Security filter chain configuration for routing and access control
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity (recommend enabling in production)
//                 .authorizeHttpRequests(requests -> requests // This is the updated method for Spring Security 5.x/6.x
//                         .requestMatchers("/login", "/css/**", "/images/**").permitAll()  // Permit access to login page and static files
//                         .anyRequest().authenticated())
//                 .formLogin(login -> login
//                         .loginPage("/login")  // Specify custom login page
//                         .permitAll()  // Allow access to the login page
//                         .successHandler((request, response, authentication) -> {
//                             String role = authentication.getAuthorities().stream()
//                                     .findFirst()
//                                     .get()
//                                     .getAuthority();

//                             if (role.equals("ROLE_PATIENT")) {
//                                 response.sendRedirect("/appointment");  // Redirect to appointment page for patient
//                             } else if (role.equals("ROLE_DOCTOR")) {
//                                 response.sendRedirect("/DoctorDashboard");  // Redirect to doctor page
//                             } else if (role.equals("ROLE_ADMIN")) {
//                                 response.sendRedirect("/Admin");  // Redirect to admin page
//                             }
//                         }))
//                 .logout(logout -> logout
//                         .logoutUrl("/logout")
//                         .logoutSuccessUrl("/login")
//                         .permitAll());

//         return http.build();
//     }
// }
