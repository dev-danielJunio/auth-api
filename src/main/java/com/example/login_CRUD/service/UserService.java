package com.example.login_CRUD.service;

import com.example.login_CRUD.model.entities.User;
import com.example.login_CRUD.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).get();
    }

    public User updateUser(Long id, User user){
        User userExisted = getUserById(id);
        userExisted.setEmail(user.getEmail());
        userExisted.setPassword(user.getPassword());

        return userRepository.save(userExisted);
    }

    public boolean deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
