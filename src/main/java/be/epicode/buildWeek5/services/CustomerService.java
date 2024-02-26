package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.Customer;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.CustomerRegisterDTO;
import be.epicode.buildWeek5.repositories.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private static CustomerDAO customerDAO;

    public Page<Customer> getCustomers(int pageNumber, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return customerDAO.findAll(pageable);
    }
    public Customer saveCustomer(CustomerRegisterDTO customerRegisterDTO) {
        Customer customer = new Customer();
        customer.setEmail(customerRegisterDTO.email());
        customer.setAnnualTurnover(customerRegisterDTO.annualTurnover());
        customer.setBusinessName(customerRegisterDTO.businessName());
        customer.setDateLastContact(customerRegisterDTO.dateLastContact());
        customer.setVatNumber(customerRegisterDTO.vatNumber());
        customer.setPec(customerRegisterDTO.pec());
        customer.setPhone(customerRegisterDTO.phone());
        customer.setSertionDate(customerRegisterDTO.sertionDate());
        return customer;
    }
    public static Customer findById(UUID customerId) {
        return customerDAO.findById(customerId).orElseThrow(() -> new NotFoundException(customerId));
    }
    public Customer findByIdAndUpdate(UUID customerId, Customer updatingCustomer) {
        Customer customer = findById(customerId);
        customer.setEmail(updatingCustomer.getEmail());
        customer.setAnnualTurnover(updatingCustomer.getAnnualTurnover());
        customer.setBusinessName(updatingCustomer.getBusinessName());
        customer.setDateLastContact(updatingCustomer.getDateLastContact());
        customer.setVatNumber(updatingCustomer.getVatNumber());
        customer.setPec(updatingCustomer.getPec());
        customer.setPhone(updatingCustomer.getPhone());
        customer.setSertionDate(updatingCustomer.getSertionDate());
        return customerDAO.save(customer);
    }

    public void findByIdAndDelete(UUID customerId) {
        Customer customer = findById(customerId);
        customerDAO.delete(customer);
    }
}
