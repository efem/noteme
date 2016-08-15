package info.noteme.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import info.noteme.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSourceConfig dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  
	  http.csrf().disable()
      .authorizeRequests()
          .antMatchers("/user/register/**").permitAll()
          .antMatchers("/note/**").permitAll()
          .antMatchers("/").permitAll()
          .anyRequest().authenticated()
          .and()
      .formLogin()
          .loginPage("/user/login")
          .permitAll()
          .and()
      .headers()
          .frameOptions().disable()
          .and()
      .logout()
          .permitAll();
		}
   

   @Autowired
   private CustomUserDetailsService userDetailsService;

   @Bean
   public DaoAuthenticationProvider authProvider() {
       DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       authProvider.setUserDetailsService(userDetailsService);
       authProvider.setPasswordEncoder(passwordEncoder());
       return authProvider;
   }

   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(authProvider());
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

}
