package com.br.workshopmongo.workshopmongo.dto;

import com.br.workshopmongo.workshopmongo.domain.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentDTO {

    private String id;
    private String text;
    private String date;
    private AuthorDTO authorDTO;

    public CommentDTO(){

    }

    public CommentDTO(String id,String text,String date,AuthorDTO authorDTO){
        this.id = id;
        this.text = text;
        this.date = date;
        this.authorDTO = authorDTO;
    }

    public Comment fromDTO(CommentDTO commentDTO){
        return new Comment(
                commentDTO.getId(),
                commentDTO.getText(),
                commentDTO.getDate()
        );
    }
}
