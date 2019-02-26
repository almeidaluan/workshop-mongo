package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){

        User user01 = User.builder().id("1").email("email@email.com").name("Fulano").build();
        User user02 = User.builder().id("2").email("ciclano@email.com").name("Ciclano").build();

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user01,user02));

        return ResponseEntity.ok().body(list);
    }
}
