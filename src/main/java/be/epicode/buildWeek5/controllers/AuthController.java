package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.User;
import be.epicode.buildWeek5.payloads.LoginResponseDTO;
import be.epicode.buildWeek5.payloads.UserDTO;
import be.epicode.buildWeek5.payloads.UserLoginDTO;
import be.epicode.buildWeek5.services.AuthService;
import be.epicode.buildWeek5.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UsersService usersService;


    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody UserLoginDTO body){
        return new LoginResponseDTO(authService.authenticateUserAndGenerateToken(body));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody UserDTO body){
        return this.authService.save(body);
    }



}
