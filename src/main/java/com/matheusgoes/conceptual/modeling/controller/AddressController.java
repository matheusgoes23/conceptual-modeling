package com.matheusgoes.conceptual.modeling.controller;

import com.matheusgoes.conceptual.modeling.dto.AddressDTO;
import com.matheusgoes.conceptual.modeling.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<Page<AddressDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(addressService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody @Valid AddressDTO addressDTO) {
        return new ResponseEntity<>(addressService.save(addressDTO), HttpStatus.CREATED);
    }
}
