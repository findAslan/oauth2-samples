package com.example;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.UserService;

@SpringBootApplication
@RestController
@EnableAuthorizationServer
@EnableResourceServer
public class AuthserverApplication  {
		
	public static void main(String[] args) {
		SpringApplication.run(AuthserverApplication.class, args);
	}
								
	@RequestMapping("/resource")
	public Map<String,Object> home(Principal user) {
	    Map<String,Object> model = new HashMap<String,Object>();

	    model.put("name", user.getName());
	    model.put("content", "Hello Authserver");
	    return model;
	}
	  
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
  
  /*
	@Configuration
	@EnableResourceServer
	protected static class ResourceServer extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
			.and()
				// Just for laughs, apply OAuth protection to only 2 resources
				.requestMatchers().antMatchers("/", "/oauth/users/**", "/oauth/clients/**", "/resource")
			.and()
				.authorizeRequests()
				.anyRequest().access("#oauth2.hasScope('openid')");
			// @formatter:on
		}
		
		@Override
		public void configure(ResourceServerSecurityConfigurer resources)
				throws Exception {
			resources.resourceId("sparklr");
		}

	}
	*/
  
  @Configuration
  @EnableAuthorizationServer
  protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
         
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    
    	endpoints.authenticationManager(authenticationManager);
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients.inMemory()
        .withClient("acme")
          .secret("acmesecret")
          .authorizedGrantTypes("authorization_code", "refresh_token", "password")
          .scopes("openid")
          .autoApprove(true)
          .accessTokenValiditySeconds(3600);
    }
    
  }
 
  /*
  @Configuration
  @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
  protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .httpBasic().and()
        .authorizeRequests()
        .antMatchers("/index.html", "/home.html", "/login.jsp", "/").permitAll().anyRequest()
        .authenticated();
    }
  }
	*/
  
  @Autowired
  private DataSource dataSource;

    @Autowired
    private UserService userDetailsService;

    // Global authentication configuration ordered *after* the one in Spring
 	// Boot (so the settings here overwrite the ones in Boot). The explicit
 	// order is not needed in Spring Boot 1.2.3 or greater. (Actually with Boot
 	// 1.2.3 you don't need this inner class at all and you can just @Autowired
 	// the AuthenticationManagerBuilder).
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  
  	PasswordEncoder encoder = new BCryptPasswordEncoder();
		//auth
		//	.inMemoryAuthentication()
		//		.withUser("min").password("min").roles("USER");
	  
	  auth
			.userDetailsService(userDetailsService)
		    //	.passwordEncoder(encoder)
		    //.and()
			;	
  }
}
