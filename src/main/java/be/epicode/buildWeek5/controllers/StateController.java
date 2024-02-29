package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.State;
import be.epicode.buildWeek5.payloads.invoices.StateDTO;
import be.epicode.buildWeek5.repositories.StateDAO;
import be.epicode.buildWeek5.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private StateDAO stateDAO;

    @GetMapping
    public Page<State> getStates(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String sort) {
        return stateService.getAllStates(page, size, sort);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public State create(@RequestBody StateDTO state) {
//        if (validation.hasErrors()) {
//            System.out.println(validation.getAllErrors());
//            throw new BadRequestException("Something went wrong in the payload!");
//        } else {
            return this.stateService.saveState(state);
        }


        @PutMapping("/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
        public State updateState (@PathVariable UUID id, @RequestBody StateDTO body){
            return stateService.updateStateById(id, body);
        }


        @DeleteMapping("/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById (@PathVariable UUID id){
            stateService.deleteStateById(id);
        }


        @GetMapping("/state-name")
        public Page<State> findByStateName ( @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sort,
        @PathVariable String stateName){
            return stateService.findByStateName(page, size, sort, stateName);
        }


    }