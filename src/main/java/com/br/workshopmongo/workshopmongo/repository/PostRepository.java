package com.br.workshopmongo.workshopmongo.repository;


import com.br.workshopmongo.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
 * ignorecase no final do metodo faz com que aceite tanto maiusculas quanto minusculas, se voce seguir o padrao o jpa monta a query pra voce
 * com base no que voce quer findByAlgumaCoisa
 */
@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    List<Post> findByTitleContainingIgnoreCase(String title);
    List<Post> findByTitleOrBodyContaining(String title,String body);
}
