package gb.ru.oauthserver.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService inMemoryUserDetailsManager(){
        var userBuilder = User.builder();
        UserDetails admin = userBuilder
                .username("admin")
                .password("{noop}password")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

}
