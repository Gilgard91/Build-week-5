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

import java.util.Random;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private  CustomerDAO customerDAO;
Random random = new Random();
    public Page<Customer> getCustomers(int pageNumber, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return this.customerDAO.findAll(pageable);
    }
    public Customer saveCustomer(CustomerRegisterDTO customerRegisterDTO) {
        Customer customer = new Customer();
        customer.setEmail(customerRegisterDTO.email());
        customer.setAnnualTurnover(random.nextInt(100000,1000000),customerRegisterDTO.annualTurnover());
        customer.setBusinessName(customerRegisterDTO.businessName());
        customer.setDateLastContact(customerRegisterDTO.dateLastContact());
        customer.setVatNumber(String.valueOf(random.nextInt(100000,1000000)),customerRegisterDTO.vatNumber());
        customer.setPec(customerRegisterDTO.nameContact(),customerRegisterDTO.surnameContact(),customerRegisterDTO.pec());
        customer.setPhone(customerRegisterDTO.phone());
        customer.setSertionDate(customerRegisterDTO.sertionDate());
        customer.setEmailContact(customerRegisterDTO.email());
        customer.setNameContact(customerRegisterDTO.nameContact());
        customer.setSurnameContact(customerRegisterDTO.surnameContact());
        customer.setPhoneContact(customerRegisterDTO.phone());
        customer.setBusinessLogo("https://www.google.com/imgres?nid=k-make-you-laugh%2F&docid=hEAxWkpf0HHSKHDlAQMygUegUIARCdAQ");
        return this.customerDAO.save(customer);
    }
    public Customer findById(UUID customerId) {
        return this.customerDAO.findById(customerId).orElseThrow(() -> new NotFoundException(customerId));
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
        return this.customerDAO.save(customer);
    }

    public void findByIdAndDelete(UUID customerId) {
        Customer customer = findById(customerId);
        this.customerDAO.delete(customer);
    }

}
