package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.dto.UserDTO;
import com.br.workshopmongo.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
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
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO){

        User user = UserDTO.fromDTO(userDTO);
        User user_save = userService.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user_save);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){

        User got_user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(got_user));
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
       userService.delete(id);
       return ResponseEntity.noContent().build();

    }

}
