package com.crud.BootCrud.service;

import com.crud.BootCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crud.BootCrud.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> printAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
    @Override
    public void editUser(User user) { userRepository.save(user); }
}
