package org.example.spring_boot_shopping_cart_project.security;

import org.example.spring_boot_shopping_cart_project.jwt.AuthEntryPointJwt;
import org.example.spring_boot_shopping_cart_project.jwt.JwtAuthTokenFilter;
import org.example.spring_boot_shopping_cart_project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class MySecurityConfig {

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoService();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        return daoAuthenticationProvider;
    }
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//
//                .csrf(requests -> requests.disable())
//                .cors(requests -> requests.disable())
//                .httpBasic(Customizer.withDefaults())
//                .authenticationProvider(this.authenticationProvider())
//                .formLogin(request -> request.disable())
//                .build();
//    }
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth.requestMatchers("/shopping/user/hello").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/shopping/user/register").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/shopping/user/signin").permitAll())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        httpSecurity
                .httpBasic(Customizer.withDefaults());

        httpSecurity
                .authenticationProvider(this.authenticationProvider());

        httpSecurity
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity
                .csrf(requests -> requests.disable())
                .cors(requests -> requests.disable());

        httpSecurity
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler));
        httpSecurity
                .addFilterBefore(this.authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
