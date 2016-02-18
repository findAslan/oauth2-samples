package com.example;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
@EnableZuulProxy
public class UitestApplication {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private OAuth2RestOperations restTemplate;

	@RequestMapping("/relay")
	public String relay() {
	    ResponseEntity<String> response =
	      restTemplate.getForEntity("http://localhost:9000/", String.class);
	    return "Success! (" + response.getBody() + ")";
	}
	
	@RequestMapping("/relay2")
	public String relay2() {
	    ResponseEntity<String> response =
	      restTemplate.getForEntity("http://localhost:9999/uaa/resource", String.class);
	    return "Success! (" + response.getBody() + ")";
	}
	
	@RequestMapping("/")
	public Map<String,Object> home() {
	    Map<String,Object> model = new HashMap<String,Object>();
	    model.put("id", UUID.randomUUID().toString());
	    model.put("content", "Hello World");
	    return model;
	}

  @RequestMapping("/user")
  public Principal user(Principal user) {
  	log.info("@@@@@@@@@@@@@@reach here?");
    return user;
  }

  
  // not reachable, it is default security.oauth2.sso.login-path 
  @RequestMapping("/login")
  public String login( HttpServletRequest request ) {
  	String code = request.getParameter("code");
  	log.info("@@@@@@@@@@@@@@reach here? : code = " + code);
    return code;
  }


	public static void main(String[] args) {
		SpringApplication.run(UitestApplication.class, args);
	}
	
	
}
