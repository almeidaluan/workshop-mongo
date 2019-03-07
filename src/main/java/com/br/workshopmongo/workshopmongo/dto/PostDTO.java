package com.br.workshopmongo.workshopmongo.dto;

import com.br.workshopmongo.workshopmongo.domain.Post;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PostDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private String id;
    private String date;
    private String title;
    private String body;
    private AuthorDTO author; // Assim fazemos da forma aninhada
    private List<CommentDTO> listCommentDTO;


    public PostDTO(){

    }



    public PostDTO(Post post){

        id = post.getId();
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
        author = post.getAuthor();
        listCommentDTO = post.getListaComments();

    }

    public static Post fromDTO(PostDTO postDTO){
        return new Post(postDTO.getId(),postDTO.getDate(),postDTO.getTitle(),postDTO.getBody(), postDTO.getAuthor(), postDTO.getListCommentDTO());
    }

}
