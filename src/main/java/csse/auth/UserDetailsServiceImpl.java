package csse.auth;

import csse.users.ApplicationUser;
import csse.users.UserService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service	// It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserService service;

    public UserDetailsServiceImpl(UserService userservice) {
        this.service = userservice;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApplicationUser user = service.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
                
        
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_"+user.getRoles()));
        System.out.println(authorities);

        // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
		// And used by auth manager to verify and check user authentication.
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
    
}