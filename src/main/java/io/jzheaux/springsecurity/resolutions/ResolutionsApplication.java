package io.jzheaux.springsecurity.resolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;


@SpringBootApplication
public class ResolutionsApplication extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(auths -> authz.mvcMatchers(GET, "reso"))
	}

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	public static void main(String[] args) {
		SpringApplication.run(ResolutionsApplication.class, args);
	}

}
