package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Invoice;
import be.epicode.buildWeek5.entities.State;
import be.epicode.buildWeek5.payloads.invoices.InvoiceDTO;
import be.epicode.buildWeek5.repositories.InvoiceDAO;
import be.epicode.buildWeek5.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceDAO invoiceDAO;
    @GetMapping
    public Page<Invoice> getInvoices(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String sort) {
        return invoiceService.getAllInvoices(page, size, sort);
}

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable UUID id) {
        return invoiceService.getInvoiceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Invoice create(@RequestBody @Validated InvoiceDTO invoice) {
//        if(validation.hasErrors()) {
//            System.out.println(validation.getAllErrors());
//            throw new BadRequestException("Something went wrong in the payload!");
//        } else {
            return this.invoiceService.saveInvoice(invoice);
//        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    Invoice updateById(@PathVariable UUID id, @RequestBody InvoiceDTO body) {
        return invoiceService.updateInvoiceById(id, body);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        invoiceService.deleteInvoiceById(id);
    }

    @GetMapping("/date")
    public Page<Invoice> findByDate(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sort,
                                    @PathVariable LocalDate date){
        return invoiceService.findInvoiceByDate(page, size, sort, date);
    }
    @GetMapping("/year")
    public Page<Invoice> findByYear(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sort,
                                    @PathVariable int year){
        return invoiceService.findByYear(page, size, sort, year);
    }
    @GetMapping("/state")
    public Page<Invoice> findByInvoiceState(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size,
                                            @RequestParam(defaultValue = "id") String sort,
                                            @PathVariable State invoiceState){
        return invoiceService.findByInvoiceState(page, size, sort, invoiceState);
    }
    @GetMapping("/amount-range")
    public Page<Invoice> findByAmountRange(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sort,
                                           @PathVariable double min, @PathVariable double max){
        return invoiceService.findInvoicesByAmountRange(min, max, page, size, sort);
    }

    //    @GetMapping("/client")
//    public Page<Invoice> findByClient(@RequestParam(defaultValue = "0") int page,
//                                      @RequestParam(defaultValue = "10") int size,
//                                      @RequestParam(defaultValue = "id") String sort,
//                                      @PathVariable UUID client){
//        return invoiceService.findByClient(page, size, sort, client);
//    }

}
