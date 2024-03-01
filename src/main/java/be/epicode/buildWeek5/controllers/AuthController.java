package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Utente;
import be.epicode.buildWeek5.payloads.LoginResponseDTO;
import be.epicode.buildWeek5.payloads.UtentiDTO;
import be.epicode.buildWeek5.payloads.UtentiLoginDTO;
import be.epicode.buildWeek5.services.AuthService;
import be.epicode.buildWeek5.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UtentiService utentiService;


    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody UtentiLoginDTO body){
        return new LoginResponseDTO(authService.authenticateUserAndGenerateToken(body));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente saveUser(@RequestBody UtentiDTO body){
        return this.authService.save(body);
    }



}
