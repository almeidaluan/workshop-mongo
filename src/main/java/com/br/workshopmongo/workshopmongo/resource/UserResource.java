package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.component.GenericException;
import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.dto.UserDTO;
import com.br.workshopmongo.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){

       List<User> list = userService.findAll();
       List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
       return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user){

        User user_save = userService.saveUser(user);
        return ResponseEntity.ok().body(user_save);
    }


    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id){
        User got_user = userService.findById(id);
        return ResponseEntity.ok().body(got_user);
    }

}
