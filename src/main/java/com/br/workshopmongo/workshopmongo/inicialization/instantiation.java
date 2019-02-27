package com.br.workshopmongo.workshopmongo.inicialization;

import com.br.workshopmongo.workshopmongo.domain.Post;
import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.dto.AuthorDTO;
import com.br.workshopmongo.workshopmongo.repository.PostRepository;
import com.br.workshopmongo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class instantiation implements CommandLineRunner {

    /**
     * Classe que preenche o banco com massa de dados
     */


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user = User.builder().id("1").email("email").name("name").build();
        User user02 = User.builder().id("2").email("email02").name("name02").build();

        userRepository.saveAll(Arrays.asList(user,user02));


        Post post = Post.builder().id("1").title("Melhores jogos 2019").body("conteudo dos melhores jogos").date(LocalDate.now()).author(new AuthorDTO(user)).build();


        postRepository.save(post);
    }
}
