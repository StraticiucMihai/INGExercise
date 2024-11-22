package com.ING_Exercize.INGExercise.config;

import com.ING_Exercize.INGExercise.model.Client;
import com.ING_Exercize.INGExercise.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.ING_Exercize.INGExercise.config.Roles.ROLE_ADMIN;
import static com.ING_Exercize.INGExercise.config.Roles.ROLE_USER;

@Configuration
public class DataInitializer {

    ///  temp class test only rwemove with basic user configurartion at atartup

    @Bean
    public CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Client admin = new Client();
            admin.setName("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(ROLE_ADMIN);
            userRepository.save(admin);

            Client client = new Client();
            client.setName("user");
            client.setPassword(passwordEncoder.encode("user123"));
            client.setRole(ROLE_USER);
            userRepository.save(client);
        };
    }
}
