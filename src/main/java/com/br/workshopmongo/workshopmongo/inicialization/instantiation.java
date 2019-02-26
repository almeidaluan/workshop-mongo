package com.br.workshopmongo.workshopmongo.inicialization;

import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {

    /**
     * Classe que preenche o banco com massa de dados
     */


    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User user = User.builder().id("1").email("email").name("name").build();
        User user02 = User.builder().id("2").email("email02").name("name02").build();

        userRepository.saveAll(Arrays.asList(user,user02));



    }
}
