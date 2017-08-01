package org.zerock.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.persistence.MemberRepository;

@Service
public class ZerockUserService implements UserDetailsService {
	@Autowired
	MemberRepository memberRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//User sampleUser = new User(username, "1111", Arrays.asList(new SimpleGrantedAuthority("ROLE_MANAGER")));
		
		return memberRepo.findById(username)
				.filter(m -> m != null)
				.map(m -> new ZerockSecurityUser(m)).get();
	}

}
