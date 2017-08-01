package org.zerock.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.extern.java.Log;

@EnableWebSecurity
@Log
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ZerockUserService zerockUserService;
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		log.info("build Auth global");
//		
////		auth.inMemoryAuthentication()
////			.withUser("manager")
////			.password("1111")
////			.roles("MANAGER");
//		
//		String sql1 = "select uid username, upw password, true enabled from tbl_members where uid=?";
//		String sql2 = "select member uid, role_name role from tbl_member_roles where member=?";
//		
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery(sql1)
//			.rolePrefix("ROLE_")
//			.authoritiesByUsernameQuery(sql2);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config!");
		http.authorizeRequests().antMatchers("/guest/**").permitAll();
		
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		http.formLogin().loginPage("/login");
		
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);
		
		//http.userDetailsService(zerockUserService);
		
		http.rememberMe()
			.key("zerock")
			.userDetailsService(zerockUserService)
			.tokenRepository(getJDBCRepository())
			.tokenValiditySeconds(60*60*24);
	}
	
	private PersistentTokenRepository getJDBCRepository(){
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		
		repo.setDataSource(dataSource);
		
		return repo;
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(zerockUserService).passwordEncoder(passwordEncoder());
	}
}
