package com.br.workshopmongo.workshopmongo.service;

import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.exception.ObjectNotFoundException;
import com.br.workshopmongo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){return userRepository.save(user);}

    public User findById(String id){return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));

    }

}
