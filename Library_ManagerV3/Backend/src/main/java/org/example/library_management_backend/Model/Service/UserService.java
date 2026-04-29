package org.example.library_management_backend.Model.Service;

import jakarta.transaction.Transactional;
import org.example.library_management_backend.Exception.UserException.UserNotFoundException;
import org.example.library_management_backend.Model.Entity.User;
import org.example.library_management_backend.Model.Repository.EntityRepository;
import org.example.library_management_backend.Model.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserService
{


    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(int Id){
        return userRepository.findById(Id)
                .orElseThrow(() -> new UserNotFoundException("Không tìm thấy User Id " + Id));
    }
    public User findByUsername(String username) {
        return (User) userRepository.findByUserName(username)
                .orElseThrow(() -> new UserNotFoundException("Không tìm thấy User: " + username));
    }


    public void deleteUserById(int Id){
        userRepository.deleteById(Id);

    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }







}
