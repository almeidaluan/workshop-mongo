package com.br.workshopmongo.workshopmongo.dto;

import com.br.workshopmongo.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO(){

    }

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }
}
