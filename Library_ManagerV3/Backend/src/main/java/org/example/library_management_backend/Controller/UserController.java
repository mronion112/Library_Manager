package org.example.library_management_backend.Controller;


import org.example.library_management_backend.Model.Entity.User;
import org.example.library_management_backend.Model.Service.UserService;
import org.example.library_management_backend.Configuration.APIResponse;
import org.example.library_management_backend.Configuration.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController{
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'MANAGEMENT', 'ADMIN')")
    public ResponseEntity<APIResponse<User>> findUserById(@PathVariable int id){

        User dbUser = userService.getUserById(id);

        APIResponse<User> apiResponse = new APIResponse<>(ResponseCode.SUCCESS, dbUser);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @GetMapping("/0")
    @PreAuthorize("hasAnyRole('MANAGEMENT', 'ADMIN')")
    public ResponseEntity<APIResponse<List<User>>> findAllUser(){
        List<User> listDBUser = userService.getAllUsers();
        APIResponse<List<User>> apiResponse = new APIResponse<>(ResponseCode.SUCCESS,listDBUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
