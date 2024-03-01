package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.StatoFattura;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.StatiFatturaDTO;
import be.epicode.buildWeek5.repositories.StatiFatturaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StatiFatturaService {
    @Autowired
    StatiFatturaDAO statiFatturaDAO;

    public Page<StatoFattura> getAllStatiFattura(int page, int size, String orderBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return statiFatturaDAO.findAll(pageable);
    }

    public StatoFattura getStatoFatturaById(UUID id){
        return statiFatturaDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public StatoFattura saveStatoFattura(StatiFatturaDTO body){
        StatoFattura statoFattura = new StatoFattura(body.nomeStato());
        return statiFatturaDAO.save(statoFattura);
    }


    public StatoFattura updateStatoFatturaById(UUID id, StatiFatturaDTO body){
        StatoFattura statoFattura = statiFatturaDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        statoFattura.setNomeStatoFattura(body.nomeStato());
        return statiFatturaDAO.save(statoFattura);
    }

    public void deleteStatoFatturaById(UUID id) {
        StatoFattura statoFattura = statiFatturaDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        statiFatturaDAO.delete(statoFattura);
    }

    public Page<StatoFattura> findByNomeStatoFattura(int page, int size, String orderBy, String nomeStatoFattura){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return statiFatturaDAO.findByNomeStatoFattura(nomeStatoFattura, pageable);
    }
}
