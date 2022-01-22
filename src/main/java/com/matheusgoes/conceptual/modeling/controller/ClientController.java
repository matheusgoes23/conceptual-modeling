package com.matheusgoes.conceptual.modeling.controller;

import com.matheusgoes.conceptual.modeling.dto.ClientDTO;
import com.matheusgoes.conceptual.modeling.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(clientService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody @Valid ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.save(clientDTO), HttpStatus.CREATED);
    }
}
