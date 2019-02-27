package com.br.workshopmongo.workshopmongo.dto;

import com.br.workshopmongo.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private String id;
    private String name;
    private String email;

    public UserDTO(){

    }

    // Usuario pra DTO - > return UsuarioDTO
    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
    
    // DTO para usuario - > return Usuario
    public static User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
    }

}
