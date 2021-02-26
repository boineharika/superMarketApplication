package com.learning.supermarket.freshmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.learning.supermarket.freshmarket.service.SuperMarketUserDetailsService;

@Configuration
@EnableWebSecurity
public class SuperMarketSecurityConfigration extends WebSecurityConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; //From Spring fram work --- to encode the password and save in DB
	
	@Autowired
	private SuperMarketUserDetailsService superMarketUserDetailsService;//This is our service
	
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(superMarketUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.
	        authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers("/login").permitAll()
	        .antMatchers("/contact-us").permitAll()
	        .antMatchers("/about-us").permitAll()
	        //.antMatchers("/upcoming-products").permitAll()
	        .antMatchers("/up-coming").permitAll()
	        .antMatchers("/up-coming-products").permitAll()
	        .antMatchers("/registration").permitAll()
	        .antMatchers("/admin/**").hasAuthority("Admin")
	        .anyRequest()
	        .authenticated()
	        .and().csrf().disable()
	        
	        .formLogin()
	        .loginPage("/login")
	        .usernameParameter("user_name123")
	        .passwordParameter("password")
	        .loginPage("/")
	        .failureUrl("/login?error=true")
	        .successHandler(new MySimpleUrlAuthenticationSuccessHandler())
	        
	        .and().logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/login").
	        
	        and().exceptionHandling();
	}
	
	 @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
