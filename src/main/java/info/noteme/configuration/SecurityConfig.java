package info.noteme.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSourceConfig dataSource;
	
	//@Autowired
/*	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("ja").password("123").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("12").roles("DBA");
	}*/
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
 
        final String findUserQuery = 
        		"SELECT username, password, enabled "
        		+ "FROM users "
        		+ "WHERE username = ?";
        
        final String findRolesQuery = 
        		"SELECT roles.rolename " 
        		+ "FROM users " 
        		+ "LEFT JOIN users_roles ON users.id=users_roles.userid " 
        		+ "LEFT JOIN roles ON roles.id=users_roles.roleid " 
        		+ "WHERE users.username = ?";
        
        System.out.println("PRNT: " + findUserQuery + "\n" + findRolesQuery);
         
        auth.jdbcAuthentication()
        		.dataSource(dataSource.dataSource())
                .usersByUsernameQuery(findUserQuery)
                .authoritiesByUsernameQuery(findRolesQuery);
        
        System.out.println("AUTH: " + auth.toString());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	  http.authorizeRequests()
			.antMatchers("/user/register/**").access("hasRole('ROLE_USER')")
			.and()
			    .formLogin().loginPage("/user/login").failureUrl("/user/login?error")
			    .usernameParameter("username").passwordParameter("password")		
			.and()
			    .logout().logoutSuccessUrl("/user/login?logout");
			/*.and()
			    .csrf(); 	*/	
	  http.csrf().disable();
		}
	

}
