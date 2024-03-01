package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.Fattura;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.FattureDTO;
import be.epicode.buildWeek5.repositories.FattureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FattureService {
    @Autowired
    FattureDAO fattureDAO;

    @Autowired
    ClientiService clientiService;

    public Page<Fattura> getAllFatture(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(orderBy));
        return fattureDAO.findAll(pageable);
    }

    public Fattura getFatturaById(UUID id) {
        return fattureDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Fattura updateFatturaById(UUID id, FattureDTO body) {
        Fattura fattura = fattureDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        fattura.setData(body.data());
        fattura.setImporto(body.importo());
        fattura.setStatoFattura(body.statoFattura());
        return fattureDAO.save(fattura);
    }

    public void deleteFatturaById(UUID id) {
        Fattura fattura = fattureDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        fattureDAO.delete(fattura);
    }

    public Fattura saveFattura(FattureDTO body){
        Fattura fattura = new Fattura(body.data(),body.importo(),body.cliente(),body.statoFattura());
        return fattureDAO.save(fattura);
    }

//    public Page<Invoice> findInvoiceByDate(int page, int size, String orderBy, LocalDate date){
//        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
//        return  invoiceDAO.findInvoiceByDate(date, pageable);
//    }
//
//    public Page<Invoice> findByYear(int page, int size, String orderBy, @RequestParam int year){
//        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
//        return invoiceDAO.findInvoiceByYear(year, pageable);
//    }
//    public Page<Invoice> findInvoicesByAmountRange(double minAmount, double maxAmount, int page, int size, String orderBy) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
//        return invoiceDAO.findInvoicesByAmountRange(minAmount, maxAmount, pageable);
//    }
//
//    public Page<Invoice> findByInvoiceState(int page, int size, String orderBy, State invoiceState){
//        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
//        return invoiceDAO.findByInvoiceState(invoiceState, pageable);
//    }
//
//    public Page<Invoice> findByCustomer(int page, int size, String orderBy, UUID id){
//        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
//        Customer customerFound = customerService.findById(id);
//        return invoiceDAO.findByCustomer(customerFound, pageable);
//    }
}
