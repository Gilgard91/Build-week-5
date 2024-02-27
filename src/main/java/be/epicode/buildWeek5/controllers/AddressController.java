package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Address;
import be.epicode.buildWeek5.payloads.AddressDTO;
import be.epicode.buildWeek5.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/address")

public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address saveAddress(@RequestBody AddressDTO payload){return addressService.saveAddress(payload);}

    @PutMapping("/{id}")
    public Address findByIdAndUpdate(@PathVariable UUID id, @RequestBody AddressDTO updatedAddress){
        return this.addressService.findByIdAndUpdate(id, updatedAddress );
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        addressService.findByIdAndDelete(id);
    }

}
