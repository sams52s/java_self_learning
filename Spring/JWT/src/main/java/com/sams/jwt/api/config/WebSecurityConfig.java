package com.sams.jwt.api.config;

import com.sams.jwt.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.sams.jwt.model.dto.AppUserRole.*;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "index","/css/*", "/js/*").permitAll()
                    .antMatchers("/index").permitAll()
                    .antMatchers("/showFormForUpdate/**").permitAll()
                    .antMatchers("/deleteUser/**").permitAll()
                    .antMatchers("/userUpdate").permitAll()
                    .antMatchers("/home/**").permitAll()
                //.hasRole(ADMIN.name())
                    .antMatchers("/profile/**").permitAll()
                    .antMatchers("/alluser/**").permitAll()
                //.hasAnyRole("USER", "ADMIN")
                    .antMatchers("/registration/**").permitAll()
                    .antMatchers("/confirm/**").permitAll()
                .anyRequest()
                    .authenticated()
                .and()
                .oauth2Login()
                    .loginPage("/login")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                  //  .defaultSuccessUrl("/profile", true)
                    .passwordParameter("password")
                    .usernameParameter("username")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("somethingverysecured")
                    .rememberMeParameter("remember-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login")
                    .permitAll()
                .and()
                .sessionManagement()
                .invalidSessionUrl("/login?invalid-session=true");
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}
