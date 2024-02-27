package be.epicode.buildWeek5.controllers;

import be.epicode.buildWeek5.entities.Address;
import be.epicode.buildWeek5.payloads.AddressDTO;
import be.epicode.buildWeek5.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")

public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address saveAddress(@RequestBody AddressDTO payload){return addressService.saveAddress(payload);}



}
