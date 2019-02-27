package com.br.workshopmongo.workshopmongo.service;

import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.dto.UserDTO;
import com.br.workshopmongo.workshopmongo.exception.ObjectNotFoundException;
import com.br.workshopmongo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){return userRepository.save(user);}

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        Optional<User> newObj = userRepository.findById(user.getId());
        updateData(newObj,user);
        return userRepository.save(newObj.get());
    }

    private void updateData(Optional<User> newObj, User user) {

        newObj.get().setId(user.getId());
        newObj.get().setEmail(user.getEmail());
        newObj.get().setName(user.getName());
    }
}
