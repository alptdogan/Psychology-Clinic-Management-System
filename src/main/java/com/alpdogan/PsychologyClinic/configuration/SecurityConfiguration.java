package com.alpdogan.PsychologyClinic.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails therapist = User.withDefaultPasswordEncoder()
                .username("therapist")
                .password("therapist")
                .roles("THERAPIST")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(therapist, admin);

    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    try {
                        auth.antMatchers("/home").permitAll()
                                .antMatchers("/modality/**").hasRole("ADMIN")

                                .antMatchers("/approach/**").hasRole("ADMIN")

                                .antMatchers("/clients/new").hasAnyRole("ADMIN", "THERAPIST")
                                .antMatchers("/clients/addClient").hasAnyRole("ADMIN", "THERAPIST")
                                .antMatchers("/clients/details").hasAnyRole("ADMIN", "THERAPIST")
                                .antMatchers("/clients/update").hasAnyRole("ADMIN", "THERAPIST")
                                .antMatchers("/clients/delete").hasRole("ADMIN")

                                .antMatchers("/therapists/new").hasAnyRole("ADMIN", "THERAPIST")
                                .antMatchers("/therapists/addTherapist").hasAnyRole("ADMIN", "THERAPIST")
                                .antMatchers("/therapists/details").hasAnyRole("ADMIN", "THERAPIST")
                                .antMatchers("/therapists/update").hasAnyRole("ADMIN", "THERAPIST")
                                .antMatchers("/therapists/delete").hasRole("ADMIN")

                                .antMatchers("/dashboard").authenticated()
                                .and().formLogin().loginPage("/login")
                                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .httpBasic(withDefaults())
                .build();

    }

}
