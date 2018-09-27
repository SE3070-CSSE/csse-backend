package csse.auth;

import static csse.auth.SecurityConstants.SIGN_UP_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity	// Enable security config. This annotation denotes config for spring security.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
    private UserDetailsServiceImpl UsersService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Bean
//   	public PasswordEncoder passwordEncoder(){
//   		PasswordEncoder encoder = new BCryptPasswordEncoder();
//   		return encoder;
//   	}
    
    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl UsersService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.UsersService = UsersService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

	

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
        .cors()
        .and()
        .csrf().disable()
        .authorizeRequests() // authorization requests config
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers("/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources",
                        "/swagger-resources/configuration/security",
                        "/swagger-resources/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()	// Any other request must be authenticated
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    // Spring has UserDetailsService interface, which can be overriden to provide our implementation for fetching user from database (or any other source).
 	// The UserDetailsService object is used by the auth manager to load the user from database.
 	// In addition, we need to define the password encoder also. So, auth manager can compare and verify passwords.
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(UsersService).passwordEncoder(bCryptPasswordEncoder);
    }

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    //     final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    //     return source;
    // }
}