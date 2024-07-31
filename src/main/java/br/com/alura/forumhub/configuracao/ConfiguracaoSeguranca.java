package br.com.alura.forumhub.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.devtools.restart.Restarter.disable;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca {

    @Bean
    public InMemoryUserDetailsManager gerenciarUsuariosEmMemoria() {
        UserDetails usuario = User.withDefaultPasswordEncoder()
                .username("usuario")
                .password("senha")
                .roles("USUARIO")
                .build();

        return new InMemoryUserDetailsManager(usuario);
    }

    @Bean
    public SecurityFilterChain configurar(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }
}
