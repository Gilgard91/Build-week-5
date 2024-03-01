package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.StatoFattura;
import be.epicode.buildWeek5.payloads.StatiFatturaDTO;
import be.epicode.buildWeek5.repositories.StatiFatturaDAO;
import be.epicode.buildWeek5.services.StatiFatturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/stati-fattura")
public class StatiFatturaController {
    @Autowired
    private StatiFatturaService statiFatturaService;
    @Autowired
    private StatiFatturaDAO statiFatturaDAO;

    @GetMapping
    public Page<StatoFattura> getStatiFattura(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "id") String sort) {
        return statiFatturaService.getAllStatiFattura(page, size, sort);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public StatoFattura save(@RequestBody StatiFatturaDTO state) {
//        if (validation.hasErrors()) {
//            System.out.println(validation.getAllErrors());
//            throw new BadRequestException("Something went wrong in the payload!");
//        } else {
            return this.statiFatturaService.saveStatoFattura(state);
        }


        @PutMapping("/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
        public StatoFattura updateStatoFattura (@PathVariable UUID id, @RequestBody StatiFatturaDTO body){
            return statiFatturaService.updateStatoFatturaById(id, body);
        }


        @DeleteMapping("/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById (@PathVariable UUID id){
            statiFatturaService.deleteStatoFatturaById(id);
        }


        @GetMapping("/nome-stato-fattura")
        public Page<StatoFattura> findByNomeStatoFattura (@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size,
                                                   @RequestParam(defaultValue = "id") String sort,
                                                   @PathVariable String stateName){
            return statiFatturaService.findByNomeStatoFattura(page, size, sort, stateName);
        }


    }