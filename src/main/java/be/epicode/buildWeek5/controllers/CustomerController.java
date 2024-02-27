package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Customer;
import be.epicode.buildWeek5.payloads.CustomerRegisterDTO;
import be.epicode.buildWeek5.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private  CustomerService customerService;

    @GetMapping
    public Page<Customer> getAllCustomer(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String orderBy) {
        return this.customerService.getCustomers(page, size, orderBy);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody CustomerRegisterDTO newCustomer) {
        return this.customerService.saveCustomer(newCustomer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable UUID id) {
        return this.customerService.findById(id);
    }

    @PutMapping("/{id}")
    public Customer findByIdAndUpdate(@PathVariable UUID customerId, @RequestBody Customer updatingCustomer) {
        return this.customerService.findByIdAndUpdate(customerId, updatingCustomer);
    }

@DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdDelete(@PathVariable UUID customerId) {
        this.customerService.findByIdAndDelete(customerId);
}

}
