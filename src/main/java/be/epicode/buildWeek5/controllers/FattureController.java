package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Fattura;
import be.epicode.buildWeek5.payloads.FattureDTO;
import be.epicode.buildWeek5.repositories.FattureDAO;
import be.epicode.buildWeek5.services.FattureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fatture")
public class FattureController {
    @Autowired
    private FattureService fattureService;
    @Autowired
    private FattureDAO fattureDAO;
    @GetMapping
    public Page<Fattura> getFatture(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "100") int size,
                                     @RequestParam(defaultValue = "id") String sort) {
        return fattureService.getAllFatture(page, size, sort);
}

    @GetMapping("/{id}")
    public Fattura getFatturaById(@PathVariable UUID id) {
        return fattureService.getFatturaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Fattura create(@RequestBody @Validated FattureDTO invoice) {
//        if(validation.hasErrors()) {
//            System.out.println(validation.getAllErrors());
//            throw new BadRequestException("Something went wrong in the payload!");
//        } else {
            return this.fattureService.saveFattura(invoice);
//        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    Fattura updateById(@PathVariable UUID id, @RequestBody FattureDTO body) {
        return fattureService.updateFatturaById(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        fattureService.deleteFatturaById(id);
    }


    @GetMapping("/filtraPerCliente")
    public List<Fattura> filtraPerCliente(@RequestParam String ragioneSociale){
        return this.fattureService.filtraPerCliente(ragioneSociale);
    }

    @GetMapping("/filtraPerStato")
    public List<Fattura> filtraPerStato(@RequestParam String stato){
        return this.fattureService.filtraPerNomeStatoFattura(stato);
    }

    @GetMapping("/filtraPerData")
    public List<Fattura> filtraPerData(@RequestParam LocalDate data){
        return this.fattureService.filtraPerData(data);
    }

    @GetMapping("/filtraPerAnno")
    public List<Fattura> filtraPerAnno(@RequestParam LocalDate inizio, @RequestParam LocalDate fine){
        return this.fattureService.filtraPerAnno(inizio,fine);
    }

    @GetMapping("/filtraPerImporti")
    public List<Fattura> filtraPerImporti(@RequestParam double min, @RequestParam double max){
        return this.fattureService.filtraPerImporti(min, max);
    }



}
