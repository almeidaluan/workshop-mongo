package com.br.workshopmongo.workshopmongo.repository;

import com.br.workshopmongo.workshopmongo.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
}
