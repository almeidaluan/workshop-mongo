package com.br.workshopmongo.workshopmongo.dto;

import com.br.workshopmongo.workshopmongo.domain.Post;
import com.br.workshopmongo.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostDTO {

    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private AuthorDTO author;

    public PostDTO(Post post){

        id = post.getId();
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
        author = post.getAuthor();

    }

    public static Post fromDTO(PostDTO postDTO){
        return new Post(postDTO.getId(),postDTO.getDate(),postDTO.getTitle(),postDTO.getBody(),postDTO.getAuthor());
    }

}
