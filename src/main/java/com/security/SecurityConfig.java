package com.security;

import com.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/static/**")
                .antMatchers("/js/**")
                .antMatchers("/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**","/login", "/registration").permitAll()
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/advertisment_list").hasAnyRole("USER", "ADMIN")
                .antMatchers("/advertisment_list_by_city").hasAnyRole("USER", "ADMIN")
                .antMatchers("/book_advertisment").hasAnyRole("USER", "ADMIN")
                .antMatchers("/edit_advertisment_form").hasAnyRole("USER", "ADMIN")
                .antMatchers("/new_adv").hasAnyRole("USER", "ADMIN")
                .antMatchers("/search").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .permitAll();
    }

//        		http
//		.authorizeRequests()
//
//		// Web admin
//		.antMatchers("/admin").hasAnyRole("ADMIN")
//		.antMatchers("/users").hasAnyRole("ADMIN")
//
//		// Comment moderator
//		.antMatchers("/comments/moderation").hasAnyRole("COMMENT_MODERATOR")
//		.antMatchers("/hotels/*/comments/*/approve").hasAnyRole("COMMENT_MODERATOR")
//		.antMatchers("/hotels/*/comments/*/remove").hasAnyRole("COMMENT_MODERATOR")
//
//		// Hotel Manager
//		/* Filtrar bookings para so mostrar os do manager
//		   Falta adicionar resposta a comment */
//		.antMatchers("/bookings").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/bookings/*/approve").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/bookings/*/remove").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/new").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/*/rooms/*").hasRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/*/upload").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/*/edit").hasAnyRole("HOTEL_MANAGER")
//		.antMatchers("/hotels/*/remove").hasAnyRole("ADMIN", "HOTEL_MANAGER")
//		.antMatchers("/hotels/*/remove_image/*").hasAnyRole("HOTEL_MANAGER")
//
//		.antMatchers("/users/me").authenticated()
//		.anyRequest().permitAll();


}
