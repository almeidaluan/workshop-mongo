package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.domain.Post;
import com.br.workshopmongo.workshopmongo.dto.PostDTO;
import com.br.workshopmongo.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {


        @Autowired
        private PostRepository postRepository;


        @GetMapping
        public ResponseEntity<List<PostDTO>> findAllPosts() {

            List<Post> listaPosts = postRepository.findAll();
            List<PostDTO>listaPostsDTO = listaPosts.stream().map( x -> new PostDTO(x)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listaPostsDTO);
        }

}
