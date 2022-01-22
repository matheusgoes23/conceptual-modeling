package com.matheusgoes.conceptual.modeling.service;

import com.matheusgoes.conceptual.modeling.dto.AddressDTO;
import com.matheusgoes.conceptual.modeling.dto.CityDTO;
import com.matheusgoes.conceptual.modeling.dto.ClientDTO;
import com.matheusgoes.conceptual.modeling.exception.ObjectNotFoundException;
import com.matheusgoes.conceptual.modeling.model.Address;
import com.matheusgoes.conceptual.modeling.repository.AddressRepository;
import com.matheusgoes.conceptual.modeling.repository.CityRepository;
import com.matheusgoes.conceptual.modeling.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public Page<AddressDTO> findAll(Pageable pageable) {
        Page<Address> page = addressRepository.findAll(pageable);
        return page.map(AddressDTO::new);
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Address.class.getName());
        }
        return new AddressDTO(address.get());
    }

    @Transactional
    public AddressDTO save(AddressDTO addressDTO) {
        addressDTO.setClient(new ClientDTO(clientRepository.findById(addressDTO.getClient().getId()).get()));
        addressDTO.setCity(new CityDTO(cityRepository.findById(addressDTO.getCity().getId()).get()));
        Address address = addressRepository.save(AddressDTO.toEntity(addressDTO));
        return new AddressDTO(address, address.getClient());
    }
}
