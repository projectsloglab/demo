package com.example.demo.api;

import com.example.demo.model.Address;
import com.example.demo.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping(value="/create")
    public ResponseEntity<?> create(@RequestBody Address address){
        addressRepository.save(address);
        return ResponseEntity.ok("Gucci address create");
    }

    @PutMapping(value="/update")
    public ResponseEntity<?> update(@RequestBody Address address){
        if(address.getId() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed af");
        }
        addressRepository.save(address);
        return ResponseEntity.ok("Gucci Address update");
    }

    @GetMapping(value = "findAll")
    public ResponseEntity<?> findAllById(){
        List<Address> addressList = addressRepository.findByOrderByIdAsc();
        return ResponseEntity.ok().body(addressList);
    }

    @GetMapping(value = "/findByCountry")
    public ResponseEntity<?> findByCountry(
            @RequestParam(value = "country")
            String country
    ){
        List<Address> addressList = addressRepository.findByCountry(country);
        return ResponseEntity.ok().body(addressList);
    }


}
