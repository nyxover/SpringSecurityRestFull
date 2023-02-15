package com.example.springsecurityresful;

import com.example.springsecurityresful.entity.Role;
import com.example.springsecurityresful.entity.User;
import com.example.springsecurityresful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityResfulApplication {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityResfulApplication.class, args);
    }



    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Role roleUser = new Role("USER");
                User user = new User("pierre", passwordEncoder.encode("pierre"));
                User user1 = new User("pierre1", passwordEncoder.encode("pierre1"));
                User user2 = new User("pierre2", passwordEncoder.encode("pierre2"));
                user.setRoleList(Arrays.asList((com.example.springsecurityresful.entity.Role) roleUser));
                userRepository.save(user);
                }
            };
        }
    }

