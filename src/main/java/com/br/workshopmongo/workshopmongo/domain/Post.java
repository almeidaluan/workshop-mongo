package com.br.workshopmongo.workshopmongo.domain;

import com.br.workshopmongo.workshopmongo.dto.AuthorDTO;
import com.br.workshopmongo.workshopmongo.dto.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Post implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    private String id;
    private String date;
    private String title;
    private String body;
    private AuthorDTO author; // forma aninhada
    private List<CommentDTO> listaComments = new ArrayList<>()  ; // forma aninhada

    public Post(String id, String date, String title, String body, AuthorDTO author) {
        super();
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }


}
