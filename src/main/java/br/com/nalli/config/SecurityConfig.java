package br.com.nalli.config;

import br.com.nalli.security.jwt.JwtConfigurer;
import br.com.nalli.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider tokenProvider;


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        BCryptPasswordEncoder  bcryptPasswordEncoder = new BCryptPasswordEncoder();

        return bcryptPasswordEncoder;
    }

    @Bean
    public AuthenticationManager   authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }


    protected void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signin"," /api-docs/**","swagger-ui.html**").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/users").denyAll()
                .and()
                .apply(new JwtConfigurer(tokenProvider));
    }
}
