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

import java.time.LocalDate;
import java.util.List;
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

    public List<Fattura> filtraPerCliente(String ragioneSociale){
        return fattureDAO.findByClienteRagioneSocialeIgnoreCase(ragioneSociale);
    }

    public List<Fattura> filtraPerNomeStatoFattura(String nomeStato){
        return fattureDAO.findByStatoFatturaNomeStatoFatturaIgnoreCase(nomeStato);
    }

    public List<Fattura> filtraPerData(LocalDate data){
        return fattureDAO.findByData(data);
    }
    public List<Fattura> filtraPerAnno(LocalDate inizioAnno, LocalDate fineAnno){
        return fattureDAO.findByDataBetween(inizioAnno,fineAnno);
    }
    public List<Fattura> filtraPerImporti(double minImporto, double maxImporto){
        return fattureDAO.findByImportoBetween(minImporto,maxImporto);
    }
}
