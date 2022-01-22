package com.matheusgoes.conceptual.modeling.service;

import com.matheusgoes.conceptual.modeling.dto.ClientDTO;
import com.matheusgoes.conceptual.modeling.exception.ObjectNotFoundException;
import com.matheusgoes.conceptual.modeling.model.Client;
import com.matheusgoes.conceptual.modeling.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(client -> new ClientDTO(client, client.getAddresses()));
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName());
        }
        return new ClientDTO(client.get(), client.get().getAddresses());
    }

    @Transactional
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = clientRepository.save(ClientDTO.toEntity(clientDTO));
        return new ClientDTO(client);
    }
}
