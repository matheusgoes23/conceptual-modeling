package com.matheusgoes.conceptual.modeling.service;

import com.matheusgoes.conceptual.modeling.dto.CityDTO;
import com.matheusgoes.conceptual.modeling.dto.StateDTO;
import com.matheusgoes.conceptual.modeling.exception.ObjectNotFoundException;
import com.matheusgoes.conceptual.modeling.model.City;
import com.matheusgoes.conceptual.modeling.repository.CityRepository;
import com.matheusgoes.conceptual.modeling.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Transactional(readOnly = true)
    public Page<CityDTO> findAll(Pageable pageable) {
        Page<City> page = cityRepository.findAll(pageable);
        return page.map(CityDTO::new);
    }

    @Transactional(readOnly = true)
    public CityDTO findById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + City.class.getName());
        }
        return new CityDTO(city.get());
    }

    @Transactional
    public CityDTO save(CityDTO cityDTO) {
        cityDTO.setState(new StateDTO(stateRepository.findById(cityDTO.getState().getId()).get()));
        City city = cityRepository.save(CityDTO.toEntity(cityDTO));
        return new CityDTO(city);
    }
}
