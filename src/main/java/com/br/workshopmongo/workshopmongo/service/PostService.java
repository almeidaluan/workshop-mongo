package com.br.workshopmongo.workshopmongo.service;

import com.br.workshopmongo.workshopmongo.domain.Post;
import com.br.workshopmongo.workshopmongo.exception.ObjectNotFoundException;
import com.br.workshopmongo.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContaining(text);
    }
}
