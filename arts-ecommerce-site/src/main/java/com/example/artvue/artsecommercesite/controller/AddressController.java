package com.example.artvue.artsecommercesite.controller;

import com.example.artvue.artsecommercesite.entity.Address;
import com.example.artvue.artsecommercesite.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }
   //update method
    @PutMapping("/update/{addressID}")
    public Address updateAddress(@PathVariable int addressID, @RequestBody Address updatedAddress) {
        return addressService.updateAddress(addressID, updatedAddress);
    }

//    @DeleteMapping("/delete/{addressID}")
//    public void deleteAddress(@PathVariable int addressID) {
//        addressService.deleteAddress(addressID);
//    }
}

