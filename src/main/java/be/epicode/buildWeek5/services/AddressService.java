package be.epicode.buildWeek5.services;


import be.epicode.buildWeek5.entities.Address;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.AddressDTO;
import be.epicode.buildWeek5.repositories.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    public List<Address> getAddresses(){return this.addressDAO.findAll();}

    public Address findById(UUID id){
        return addressDAO.findById(id).orElseThrow(()-> new NotFoundException("This address is not registered"));
    }

    public Address saveAddress(AddressDTO payload){
        Address newAddress = new Address();
        newAddress.setMunicipality(payload.municipality());
        newAddress.setStreet(payload.street());
        newAddress.setNumber(payload.number());
        newAddress.setPostalCode(payload.postalCode());
        newAddress.setAddressType(payload.addressType());
        return addressDAO.save(newAddress);
    }

    public Address findByIdAndUpdate(UUID id, AddressDTO payload){
        Address found = this.findById(id);
        found.setMunicipality(payload.municipality());
        found.setStreet(payload.street());
        found.setNumber(payload.number());
        found.setPostalCode(payload.postalCode());
        found.setAddressType(payload.addressType());
        return addressDAO.save(found);
    }

    public void findByIdAndDelete(UUID id){
        Address found = this.findById(id);
        addressDAO.delete(found);
    }
}
