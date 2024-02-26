package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Customer;
import be.epicode.buildWeek5.payloads.CustomerRegisterDTO;
import be.epicode.buildWeek5.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private static CustomerService customerService;

    @GetMapping
    public Page<Customer> getAllCustomer(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String orderBy) {
        return customerService.getCustomers(page, size, orderBy);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody CustomerRegisterDTO newCustomer) {
        return customerService.saveCustomer(newCustomer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable UUID id) {
        return CustomerService.findById(id);
    }

    @PutMapping("/{id}")
    public Customer findByIdAndUpdate(@PathVariable UUID customerId, @RequestBody Customer updatingCustomer) {
        return customerService.findByIdAndUpdate(customerId, updatingCustomer);
    }

@DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdDelete(@PathVariable UUID customerId) {
        customerService.findByIdAndDelete(customerId);
}

}
