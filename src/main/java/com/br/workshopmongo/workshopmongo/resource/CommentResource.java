package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.domain.Comment;
import com.br.workshopmongo.workshopmongo.dto.CommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {


    public ResponseEntity<List<CommentDTO>> listaComentarios(){
        return null;
    }
}
