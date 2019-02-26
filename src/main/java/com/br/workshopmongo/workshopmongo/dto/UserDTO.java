package com.br.workshopmongo.workshopmongo.dto;

import com.br.workshopmongo.workshopmongo.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private String id;
    private String name;
    private String email;

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
}
