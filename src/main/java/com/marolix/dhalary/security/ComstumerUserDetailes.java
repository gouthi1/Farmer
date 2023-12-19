//package com.marolix.dhalary.security;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.marolix.dhalary.Entity.Role;
//import com.marolix.dhalary.Entity.User;
//import com.marolix.dhalary.reposistry.UserReposistry;
//
//@Service
//public class ComstumerUserDetailes implements UserDetailsService{
//
//	@Autowired
//	private UserReposistry userReposistry;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		 User user=userReposistry.findByUserName(username);
//		 if (user == null) {
//	            throw new UsernameNotFoundException("User not found with username: " + username);
//	        }
//		 return new org.springframework.security.core.userdetails.User(
//		            user.getUserName(),
//		            user.getPassword(),
//		            getAuthorities(user.getRoles())
//		        );
//	    }
//	 private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
//
//		 return roles.stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.getRole())).collect(Collectors.toList());
//	        
//	        
//	    }
//}
