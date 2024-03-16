package security.service.secure.service.Authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration


    public class SecurityConfig {
        private static final Logger logger = LoggerFactory.getLogger(security.service.secure.service.Authentication.SecurityConfig.class);

        public SecurityConfig() {
            logger.info("SecurityConfig instantiated.");
        }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/").permitAll() // Permit access to all URLs
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return  http.build();
        /*http.authorizeHttpRequests(auth -> {
            auth.anyRequest().authenticated();


        });
        return http.build();*/
    }

        @Bean
        public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
            // Define custom user details
            UserDetails user = User.withUsername("user")
                    .password("{noop}password") // Password is "password"
                    .roles("USER")
                    .build();

            UserDetails admin = User.withUsername("admins")
                    .password("{noop}admin") // Password is "admin"
                    .roles("ADMIN")
                    .build();

            // Create InMemoryUserDetailsManager with custom user details
            return new InMemoryUserDetailsManager(user, admin);
        }
    }


