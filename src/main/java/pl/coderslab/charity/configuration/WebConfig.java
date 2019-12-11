package pl.coderslab.charity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.coderslab.charity.user.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public WebConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .successForwardUrl("/")
                .failureForwardUrl("/failureLogin").permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .and()
                .csrf().disable();
    }
}
