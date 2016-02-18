package com.example.user;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo user = userRepository.findByCustId(username);
		
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		
		UserDetails userDetails = (UserDetails)new User(user.getCustName(), 
				user.getPwd(), Arrays.asList(authority));
		return userDetails;
	}

}
