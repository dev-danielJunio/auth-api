package com.example.login_CRUD.controller;

import com.example.login_CRUD.infra.security.TokenService;
import com.example.login_CRUD.model.entities.AuthenticationDTO;
import com.example.login_CRUD.model.entities.LoginResponseDTO;
import com.example.login_CRUD.model.entities.RegisterDTO;
import com.example.login_CRUD.model.entities.User;
import com.example.login_CRUD.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByEmail(data.login()) != null) return ResponseEntity.badRequest().build();

        String encrypedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encrypedPassword, data.role());

        this.repository.save(newUser);
        return ResponseEntity.ok().body(newUser);
    }

}
