package ru.ishbuldin.andrei.websocketmessagechat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    @Value("${users}")
    private String users;

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build());

        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(users)) {
            properties.load(fis);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String username = entry.getKey().toString();
                String password = entry.getValue().toString();
                manager.createUser(User.builder().username(username).password(passwordEncoder().encode(password)).roles("USER").build());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return manager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}