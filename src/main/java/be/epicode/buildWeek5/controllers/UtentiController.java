package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Utente;
import be.epicode.buildWeek5.payloads.UtentiDTO;
import be.epicode.buildWeek5.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UtentiController {

    @Autowired
    private UtentiService utentiService;


    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Utente> getAllUsers(){
        return this.utentiService.getUsers();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Utente findById(@PathVariable UUID userId){
        return utentiService.findById(userId);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Utente findAndUpdate(@PathVariable UUID userId, @RequestBody UtentiDTO body){
        return utentiService.findByIdAndUpdate(userId,body);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable UUID userId){
        utentiService.findByIdAndDelete(userId);
    }



    @GetMapping("/me")
    public Utente getProfile(@AuthenticationPrincipal Utente currentUtente){
        return currentUtente;
    }

    @PutMapping("/me")
    public Utente getMeAndUpdate(@AuthenticationPrincipal Utente currentUtente, @RequestBody UtentiDTO updatedUser){
        return this.utentiService.findByIdAndUpdate(currentUtente.getId(), updatedUser);
    }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getMeAndDelete(@AuthenticationPrincipal Utente currentUtente){
        this.utentiService.findByIdAndDelete(currentUtente.getId());
    }

    @PostMapping("/upload")
    public String uploadAvatar(@RequestParam("avatar") MultipartFile img, @RequestParam("id") UUID id) throws IOException {
        return this.utentiService.uploadImg(img, id);
    }
}
