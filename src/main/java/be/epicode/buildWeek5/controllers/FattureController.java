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

//    @GetMapping("/date")
//    public Page<Invoice> findByDate(@RequestParam(defaultValue = "0") int page,
//                                    @RequestParam(defaultValue = "10") int size,
//                                    @RequestParam(defaultValue = "id") String sort,
//                                    @PathVariable LocalDate date){
//        return invoiceService.findInvoiceByDate(page, size, sort, date);
//    }
//    @GetMapping("/year")
//    public Page<Invoice> findByYear(@RequestParam(defaultValue = "0") int page,
//                                    @RequestParam(defaultValue = "10") int size,
//                                    @RequestParam(defaultValue = "id") String sort,
//                                    @PathVariable int year){
//        return invoiceService.findByYear(page, size, sort, year);
//    }
//    @GetMapping("/state")
//    public Page<Invoice> findByInvoiceState(@RequestParam(defaultValue = "0") int page,
//                                            @RequestParam(defaultValue = "10") int size,
//                                            @RequestParam(defaultValue = "id") String sort,
//                                            @PathVariable State invoiceState){
//        return invoiceService.findByInvoiceState(page, size, sort, invoiceState);
//    }
//    @GetMapping("/amount-range")
//    public Page<Invoice> findByAmountRange(@RequestParam(defaultValue = "0") int page,
//                                           @RequestParam(defaultValue = "10") int size,
//                                           @RequestParam(defaultValue = "id") String sort,
//                                           @PathVariable double min, @PathVariable double max){
//        return invoiceService.findInvoicesByAmountRange(min, max, page, size, sort);
//    }

    //    @GetMapping("/client")
//    public Page<Invoice> findByClient(@RequestParam(defaultValue = "0") int page,
//                                      @RequestParam(defaultValue = "10") int size,
//                                      @RequestParam(defaultValue = "id") String sort,
//                                      @PathVariable UUID client){
//        return invoiceService.findByClient(page, size, sort, client);
//    }

}
