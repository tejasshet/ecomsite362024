package com.example.artvue.artsecommercesite.service;

import com.example.artvue.artsecommercesite.entity.Address;
import com.example.artvue.artsecommercesite.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(int addressID, Address updatedAddress) {
        Optional<Address> addressOptional = addressRepository.findById(addressID);
        if (!addressOptional.isPresent()) {
            throw new RuntimeException("Address not found with id: " + addressID);
        }
        Address existingAddress = addressOptional.get();
        // Update the properties of the existing address with the new values
        existingAddress.setStreet(updatedAddress.getStreet());
        existingAddress.setCity(updatedAddress.getCity());
        existingAddress.setZipCode(updatedAddress.getZipCode());
        // ... Update other properties as needed

        return addressRepository.save(existingAddress);
    }
//    public void deleteAddress(int addressID) {
//        Optional<Address> addressOptional = addressRepository.findById(addressID);
//        if (!addressOptional.isPresent()) {
//            throw new RuntimeException("Address not found with id: " + addressID);
//        }
//        addressRepository.deleteById(addressID);
//    }
}
