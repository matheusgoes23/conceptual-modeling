package com.matheusgoes.conceptual.modeling.controller;

import com.matheusgoes.conceptual.modeling.dto.StateDTO;
import com.matheusgoes.conceptual.modeling.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<Page<StateDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(stateService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(stateService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StateDTO> save(@RequestBody @Valid StateDTO stateDTO) {
        return new ResponseEntity<>(stateService.save(stateDTO), HttpStatus.CREATED);
    }
}
