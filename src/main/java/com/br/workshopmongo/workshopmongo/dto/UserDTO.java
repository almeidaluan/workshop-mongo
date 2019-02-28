package com.br.workshopmongo.workshopmongo.dto;

import com.br.workshopmongo.workshopmongo.domain.Post;
import com.br.workshopmongo.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private String id;
    private String name;
    private String email;


    /**
     * O VO de usuario so retorna id,name,email mas o model de usuario possui uma referencia no banco para posts que pode ser vista no mongo mas n é listado no endpoint de usuario
     * caso queira ver os posts do usuario no endpoint, deve alterar o DTO para ter a variavel de posts
     */

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
