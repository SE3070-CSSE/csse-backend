package csse.auth;

import csse.users.ApplicationUser;
import csse.users.UserDAO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserDAO userDAO;

    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApplicationUser applicationUser = userDAO.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role: applicationUser.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return new User(applicationUser.getUsername(), applicationUser.getPassword(), authorities);
    }
}