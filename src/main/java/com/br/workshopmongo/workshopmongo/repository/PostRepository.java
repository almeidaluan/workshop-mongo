package com.br.workshopmongo.workshopmongo.repository;


import com.br.workshopmongo.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
 * ignorecase no final do metodo faz com que aceite tanto maiusculas quanto minusculas, se voce seguir o padrao o jpa monta a query pra voce
 * com base no que voce quer findByAlgumaCoisa
 */
@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    Optional<List<Post>> findByTitleContainingIgnoreCase(String title);
    Optional<List<Post>> findByTitleOrBodyContaining(String title,String body);

    /**
     * https://docs.mongodb.com/manual/reference/operator/query/regex/
     * ?0 significa pegar o primeiro parametro do metodo
     * i - para pegar tanto maiusculo quanto minusculo
     * @param text
     * @return
     */
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    Optional<List<Post>> searchTitle(String text);
}
