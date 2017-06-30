package ba.sec.app.secApp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
public class ResourceSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests()	
	.antMatchers("/resources/**").permitAll()
	.antMatchers("/**").authenticated()
	.and()
	.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
	.and()
	.logout().permitAll();
	}
	
   

    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication().dataSource(dataSource)
     .usersByUsernameQuery(
      "select email, concat(SUBSTRING(PASSWORD,33,32),SUBSTRING(PASSWORD,97,32)) as password, enabled from user where email=?")
     .authoritiesByUsernameQuery(
      "select email,role from authority where email=?");
    } 

}
