//package com.marolix.dhalary.security;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class ConfigSecurites  {
//
//	@Autowired
//	private ComstumerUserDetailes comstumerUserDetailes;
//	
//	
//	public void authManager(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(comstumerUserDetailes)
//		   .passwordEncoder(new  BCryptPasswordEncoder());
//	   
//	}
//	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		// @formatter:off
//		http
//		
//				.authorizeHttpRequests((authorize) -> {
//					
//                        try {
//                            authorize
//                                    .requestMatchers(HttpMethod.POST, "/crops/**").hasAnyRole("admin")
//                                    .requestMatchers(HttpMethod.PUT, "/crops/**").hasAnyRole("dhalary")
//                                    .requestMatchers(HttpMethod.DELETE, "/crops/**").hasAnyRole("admin")
//                                    .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
//                                    .requestMatchers(HttpMethod.GET, "/**").permitAll()
//                                    .anyRequest().authenticated()
//                                    .and()
//                                    .cors(withDefaults())
//                                    .csrf(csrf -> csrf.disable());
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}             
//				}
//				)
//				.httpBasic(withDefaults())
//				.formLogin(withDefaults());
//		
//		return http.build();
//	}
//	
//
//}
