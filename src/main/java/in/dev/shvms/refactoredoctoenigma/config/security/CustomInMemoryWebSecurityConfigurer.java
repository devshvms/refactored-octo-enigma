package in.dev.shvms.refactoredoctoenigma.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class CustomInMemoryWebSecurityConfigurer {

    /*
    * /actuator/secretMsg Can be accessed by USER
    * /actuator/** can by accessed by ADMIN (url pattern includes /actuator/secretMsg)
    * csrf is disabled to access endpoints from postman, as facing issue sending correct request with CSRF
    * formLogin will return a login form automatically to authenticate.
    */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests(
                        (authorizeRequest) -> authorizeRequest
                                .antMatchers("/actuator/secretMsg")
                                .hasRole("USER")).csrf().disable()
                .authorizeRequests(
                        (authorizeRequest) -> authorizeRequest
                                .antMatchers("/actuator/**")
                                .hasRole("ADMIN")).formLogin();
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("pass")
                .roles("USER")
                .build();
// admin credentials have 2 roles ADMIN and USER
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("QazXsw@12")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(List.of(user, admin));
    }
}
