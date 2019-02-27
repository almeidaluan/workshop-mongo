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
    private LocalDate date;

    public CommentDTO(Comment comment){
        id = comment.getId();
        text = comment.getText();
        date = comment.getDate();
    }

    public Comment fromDTO(CommentDTO commentDTO){
        return new Comment(
                commentDTO.getId(),
                commentDTO.getText(),
                commentDTO.getDate()
        );
    }
}
