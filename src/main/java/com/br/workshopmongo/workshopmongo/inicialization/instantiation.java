package com.br.workshopmongo.workshopmongo.inicialization;

import com.br.workshopmongo.workshopmongo.domain.Post;
import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.dto.AuthorDTO;
import com.br.workshopmongo.workshopmongo.dto.CommentDTO;
import com.br.workshopmongo.workshopmongo.repository.PostRepository;
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

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {



        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, "21/03/2018", "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, "23/03/2018", "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));


        CommentDTO c1 = new CommentDTO(null,"Boa viagem mano!", "21/03/2018", new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO(null,"Aproveite", "21/03/2018", new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO(null,"Tenha um ótimo dia!", "21/03/2018", new AuthorDTO(alex));

        post1.getListaComments().addAll(Arrays.asList(c1, c2));
        post2.getListaComments().addAll(Arrays.asList(c3));



        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);


    }
}
