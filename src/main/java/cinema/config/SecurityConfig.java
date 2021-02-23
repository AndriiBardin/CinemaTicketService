package cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder
                .userDetailsService(userDetailsService);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/movie-sessions/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/movie-sessions/**").hasAuthority("ADMIN")
                .antMatchers("/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,
                        "/movie-sessions/**", "/movies/**", "/cinema-halls/**")
                .hasAuthority("ADMIN")
                .antMatchers("/shopping-carts/**", "/orders/**")
                .hasAuthority("USER")
                .antMatchers(HttpMethod.GET,
                        "/movie-sessions/**", "/movies/**", "/cinema-halls/**").permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
