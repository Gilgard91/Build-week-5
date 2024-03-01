package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Cliente;
import be.epicode.buildWeek5.payloads.ClientiDTO;
import be.epicode.buildWeek5.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clienti")
public class ClientiController {

    @Autowired
    private ClientiService clientiService;

    @GetMapping
    public Page<Cliente> getAllClienti(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String orderBy) {
        return this.clientiService.getClienti(page, size, orderBy);
    }



    @GetMapping("/filtraPerNome")
    public List<Cliente> filtraPerNome(@RequestParam String parteNome){
        return clientiService.filtraPerNome(parteNome);
    }

    @GetMapping("/filtraPerFatturato")
    public List<Cliente> filtraPerFatturato(@RequestParam int minFatturato){
        return clientiService.filtraPerFatturato(minFatturato);
    }

    @GetMapping("/filtraPerDataUltimoContatto")
    public List<Cliente> filtraPerUltimoContatto(@RequestParam LocalDate data){
        return clientiService.filtraPerUltimoContatto(data);
    }

    @GetMapping("/filtraPerDataInserimento")
    public List<Cliente> filtraPerInserimento(@RequestParam LocalDate data){
        return clientiService.filtraPerDataInserimento(data);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody ClientiDTO newCliente) {
        return this.clientiService.saveCliente(newCliente);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable UUID id) {
        return this.clientiService.findById(id);
    }

    @PutMapping("/{id}")
    public Cliente findByIdAndUpdate(@PathVariable UUID clienteId, @RequestBody Cliente updatingCliente) {
        return this.clientiService.findByIdAndUpdate(clienteId, updatingCliente);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdDelete(@PathVariable UUID clienteId) {
        this.clientiService.findByIdAndDelete(clienteId);
}

}
