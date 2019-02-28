package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.domain.Comment;
import com.br.workshopmongo.workshopmongo.dto.CommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {


    @GetMapping
    public ResponseEntity<List<CommentDTO>> listComments(){
        return null;
    }

    @PostMapping
    public ResponseEntity<Comment> saveComment (@RequestBody CommentDTO comment){
        return null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> findByIdComment(@PathVariable String id){
        return null;
    }

}
