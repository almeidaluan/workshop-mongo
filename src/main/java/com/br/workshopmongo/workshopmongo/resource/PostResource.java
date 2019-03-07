package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.domain.Post;
import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.dto.PostDTO;
import com.br.workshopmongo.workshopmongo.repository.PostRepository;
import com.br.workshopmongo.workshopmongo.service.PostService;
import com.br.workshopmongo.workshopmongo.service.UserService;
import com.br.workshopmongo.workshopmongo.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {


        @Autowired
        private PostRepository postRepository;

        @Autowired
        private PostService postService;

        @GetMapping
        public ResponseEntity<List<PostDTO>> findAllPosts() {

            List<Post> listaPosts = postRepository.findAll();
            List<PostDTO>listaPostsDTO = listaPosts.stream().map( x -> new PostDTO(x)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listaPostsDTO);
        }


        @GetMapping("/{id}")
        public ResponseEntity<PostDTO> findById(@PathVariable String id){
            Post post = postService.findById(id);
            return ResponseEntity.ok().body(new PostDTO(post));
        }

        @GetMapping("/titlesearch")
        public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value="text",defaultValue = "") String text){
            text = URL.decodeURL(text);
            List<Post> posts = postService.findByTitle(text);
            List<PostDTO> listaPostsDTO = posts.stream().map( x -> new PostDTO(x)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listaPostsDTO);
        }

    /**
     * Retorna o poste por title ou body
     * @param text
     * @param body
     * @return
     */
        @GetMapping("/titlebodysearch")
        public ResponseEntity<List<PostDTO>> findByTitleOrBody(@RequestParam(value="text",defaultValue = "") String text,
                                                               @RequestParam(value = "body",defaultValue = "") String body){
            text = URL.decodeURL(text);
            List<Post> posts = postService.findByTitleOrBody(text,body);
            List<PostDTO> listaPostsDTO = posts.stream().map( x -> new PostDTO(x)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listaPostsDTO);
        }

        @PostMapping
        public ResponseEntity<Post> savePost(@RequestBody PostDTO postDTO){

            Post post = PostDTO.fromDTO(postDTO);
            Post post_save = postRepository.save(post);
            return ResponseEntity.ok().body(post_save);

        }


}
