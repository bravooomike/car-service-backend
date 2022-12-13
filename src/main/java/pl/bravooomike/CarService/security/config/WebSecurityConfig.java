package pl.bravooomike.CarService.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import pl.bravooomike.CarService.security.userIdentity.UserAuthenticationProvider;
import pl.bravooomike.CarService.security.userIdentity.UserIdentityService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserIdentityService userIdentityService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/rest/carService").permitAll()
                .antMatchers(HttpMethod.POST, "/rest/carService").access("hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.PUT, "/rest/carService/**").access("hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.DELETE, "/rest/carService/**").access("hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/rest/carService/user").permitAll()
                .antMatchers(HttpMethod.GET, "/rest/carService/user/**").access("hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.GET, "/rest/carService/auth").access("hasAnyAuthority('USER', 'ADMIN')")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new UserAuthenticationProvider(userIdentityService));
    }
 }
