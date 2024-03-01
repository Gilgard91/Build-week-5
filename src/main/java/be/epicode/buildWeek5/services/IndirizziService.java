package be.epicode.buildWeek5.services;


import be.epicode.buildWeek5.entities.Indirizzo;
import be.epicode.buildWeek5.entities.Comune;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.IndirizziDTO;
import be.epicode.buildWeek5.repositories.IndirizziDAO;
import be.epicode.buildWeek5.repositories.ComuniDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class IndirizziService {

    @Autowired
    private IndirizziDAO indirizziDAO;
    @Autowired
    private ComuniDAO comuniDAO;

    public List<Indirizzo> getIndirizzi(){return this.indirizziDAO.findAll();}

    public Indirizzo findById(int id){
        return indirizziDAO.findById(id).orElseThrow(()-> new NotFoundException("Questo indirizzo non esiste"));
    }

    public void findByIdAndDelete(int id){
        Indirizzo found = this.findById(id);
        indirizziDAO.delete(found);
    }

    public Indirizzo saveIndirizzo(IndirizziDTO body) {
        Comune found = comuniDAO.findByNome(body.comune().getNome());
        if (found == null) {
            throw new NotFoundException("Comune non trovato: " + body.comune().getNome());
        }
        Indirizzo indirizzo = new Indirizzo(body.via(),body.civico(),body.cap(),
                found);
        indirizzo.setComune(found);
        indirizziDAO.save(indirizzo);

        return indirizzo;
    }

}

