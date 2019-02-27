package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

        @PostMapping
        public ResponseEntity<Post> savePost(@RequestBody PostDTO postDTO){

            Post post = PostDTO.fromDTO(postDTO);
            Post post_save = postRepository.save(post);
            return ResponseEntity.ok().body(post_save);

        }

}
