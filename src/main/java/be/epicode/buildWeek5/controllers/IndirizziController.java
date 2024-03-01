package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Indirizzo;
import be.epicode.buildWeek5.payloads.IndirizziDTO;
import be.epicode.buildWeek5.services.IndirizziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indirizzi")

public class IndirizziController {

    @Autowired
    private IndirizziService indirizziService;

    @PostMapping
    public Indirizzo saveIndirizzo(@RequestBody IndirizziDTO payload){
        return indirizziService.saveIndirizzo(payload);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Indirizzo> getAllIndirizzi() {
        return this.indirizziService.getIndirizzi();
    }



}
