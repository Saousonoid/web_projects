package com.mvc.app.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mvc.app.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userDetailsService;
    
    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;


    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;

    
	 @Override
	    public void configure(HttpSecurity http) throws Exception {


	        http
	                .headers().disable()
	                .csrf().disable()
	                .cors().and()
	                .authorizeRequests()
	                .antMatchers("/loggedInUser", "/login", "/error","/logout","/add/user").permitAll()
	                //Only Writers and Admin can post new Articles
	                .antMatchers(HttpMethod.POST, "/add/article").hasAnyRole("WRITER","ADMIN")
	                //Only  Admin can access a list of all users, Admin and writer can access the list of articles
	                .antMatchers(HttpMethod.GET, "/articles").hasAnyRole("WRITER","ADMIN")
	                .antMatchers(HttpMethod.GET, "/users/*").hasRole("ADMIN")
	                .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                .loginPage("/error")
	                .loginProcessingUrl("/login")
	                .successHandler(restAuthenticationSuccessHandler)
                    .failureHandler(restAuthenticationFailureHandler)
	                .usernameParameter("username")
	                .passwordParameter("password")
	                .permitAll()
	                .and()
	                .logout()
	                .logoutUrl("/logout")
	                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
	                .deleteCookies("JSESSIONID")
	                .permitAll()
	                .and();
	        
	 }
	        @Override
	        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	        }

	        @Bean
	        public PasswordEncoder passwordEncoder() {
	            return NoOpPasswordEncoder.getInstance();
	        }

	        @Bean
	        @Override
	        public AuthenticationManager authenticationManagerBean() throws Exception {
	            return super.authenticationManagerBean();
	        }
	        
	        @Bean
	        //Allow front source to perform requests for all types to the server
	        CorsConfigurationSource corsConfigurationSource() {
	            HostnameCorsConfiguration configuration = new HostnameCorsConfiguration(List.of("*"), List.of());
	            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PATCH", "PUT", "DELETE"));
	            configuration.setAllowedHeaders(List.of(CorsConfiguration.ALL));
	            configuration.addAllowedOriginPattern("http://localhost:8080");
	            configuration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Private-Network")); 
	            configuration.setAllowCredentials(true);
	            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	            source.registerCorsConfiguration("/**", configuration);
	            return source;
	        }

}
