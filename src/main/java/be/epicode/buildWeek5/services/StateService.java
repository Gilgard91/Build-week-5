package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.entities.State;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.invoices.StateDTO;
import be.epicode.buildWeek5.repositories.StateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateService {
    @Autowired
    StateDAO stateDAO;

    public Page<State> getAllStates(int page, int size, String orderBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return stateDAO.findAll(pageable);
    }

    public State getStateById(UUID id){
        return stateDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public State saveState(StateDTO body){
        State state = new State();
        state.setStateName(body.stateName());
        state.setInvoices(body.invoices());
        return stateDAO.save(state);
    }


    public State updateStateById(UUID id, StateDTO body){
        State state = stateDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        state.setStateName(body.stateName());
        state.setInvoices(body.invoices());
        return stateDAO.save(state);
    }

    public void deleteStateById(UUID id) {
        State state = stateDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
        stateDAO.delete(state);
    }

    public Page<State> findByStateName(int page, int size, String orderBy, String stateName){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return stateDAO.findByStateName(stateName, pageable);
    }
}
