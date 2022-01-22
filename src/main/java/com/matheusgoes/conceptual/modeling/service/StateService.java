package com.matheusgoes.conceptual.modeling.service;

import com.matheusgoes.conceptual.modeling.dto.StateDTO;
import com.matheusgoes.conceptual.modeling.exception.ObjectNotFoundException;
import com.matheusgoes.conceptual.modeling.model.City;
import com.matheusgoes.conceptual.modeling.model.State;
import com.matheusgoes.conceptual.modeling.repository.CityRepository;
import com.matheusgoes.conceptual.modeling.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public Page<StateDTO> findAll(Pageable pageable) {
        Page<State> page = stateRepository.findAll(pageable);
        return page.map(state -> new StateDTO(state, state.getCities()));
    }

    @Transactional(readOnly = true)
    public StateDTO findById(Long id) {
        Optional<State> state = stateRepository.findById(id);
        if (state.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + State.class.getName());
        }
        return new StateDTO(state.get(), state.get().getCities());
    }

    @Transactional
    public StateDTO save(StateDTO stateDTO) {
        Set<City> cities = new HashSet<>();
        State state = stateRepository.save(StateDTO.toEntity(stateDTO));
        state.getCities().forEach(city -> cities.add(cityRepository.findById(city.getId()).get()));
        return new StateDTO(state, cities);
    }
}
