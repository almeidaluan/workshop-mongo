package com.br.workshopmongo.workshopmongo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class User implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    private String id;
    private String name;
    private String email;


    /**
     * nao quer carregar os posts quando fizer uma consulta de usuarios
     * imagina se tem mil usuarios e pra cada 1 precisa vim a lista de posts dele
     * quando carregar usuario vai vim só os dados basicos do usuario
     */
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<Post>();


    public User(String id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
