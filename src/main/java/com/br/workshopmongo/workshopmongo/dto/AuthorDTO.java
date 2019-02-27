package com.br.workshopmongo.workshopmongo.dto;

import com.br.workshopmongo.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthorDTO implements Serializable {


    private static final long serialVersionUID = 1l;

    private String id;
    private String name;

    public AuthorDTO(){

    }

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }
}
