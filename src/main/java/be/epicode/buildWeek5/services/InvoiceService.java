package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.Invoice;
import be.epicode.buildWeek5.entities.State;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.invoices.InvoiceDTO;
import be.epicode.buildWeek5.repositories.InvoiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class InvoiceService {
    @Autowired
    InvoiceDAO invoiceDAO;

    public Page<Invoice> getAllInvoices(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(orderBy));
        return invoiceDAO.findAll(pageable);
    }

    public Invoice getInvoiceById(UUID id) {
        return invoiceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Invoice updateInvoiceById(UUID id, InvoiceDTO body) {
        Invoice invoice = invoiceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        invoice.setDate(body.date());
        invoice.setAmount(body.amount());
        invoice.setInvoiceState(body.invoiceState());
        return invoiceDAO.save(invoice);
    }

    public void deleteInvoiceById(UUID id) {
        Invoice invoice = invoiceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        invoiceDAO.delete(invoice);
    }

    public Invoice saveInvoice(InvoiceDTO body){
        Invoice invoice = new Invoice(body.date(),body.amount(),body.customer(),body.invoiceState());
//        invoice.setDate(body.date());
//        invoice.setAmount(body.amount());
//        invoice.setInvoiceNumber(body.invoiceNumber());
//        invoice.setInvoiceState(body.invoiceState());
//        Client client = clientsService.findById(body.clientId());
//        invoice.setClient(client);
        return invoiceDAO.save(invoice);
    }

    public Page<Invoice> findInvoiceByDate(int page, int size, String orderBy, LocalDate date){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return  invoiceDAO.findInvoiceByDate(date, pageable);
    }

    public Page<Invoice> findByYear(int page, int size, String orderBy, @RequestParam int year){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return invoiceDAO.findInvoiceByYear(year, pageable);
    }
    public Page<Invoice> findInvoicesByAmountRange(double minAmount, double maxAmount, int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return invoiceDAO.findInvoicesByAmountRange(minAmount, maxAmount, pageable);
    }

    public Page<Invoice> findByInvoiceState(int page, int size, String orderBy, State invoiceState){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return invoiceDAO.findByInvoiceState(invoiceState, pageable);
    }

   // public Page<Invoice> findByClient(int page, int size, String orderBy, UUID id){
//        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
//        Client clientFound = clientsService.findById(id);
//        return invoiceDAO.findByClient(clientFound, pageable);
//    }
}
