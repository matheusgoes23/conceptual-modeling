package com.matheusgoes.conceptual.modeling.controller;

import com.matheusgoes.conceptual.modeling.dto.CityDTO;
import com.matheusgoes.conceptual.modeling.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<Page<CityDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(cityService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cityService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CityDTO> save(@RequestBody @Valid CityDTO cityDTO) {
        return new ResponseEntity<>(cityService.save(cityDTO), HttpStatus.CREATED);
    }
}
