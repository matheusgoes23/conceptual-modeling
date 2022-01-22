package com.matheusgoes.conceptual.modeling.dto;

import com.matheusgoes.conceptual.modeling.model.City;
import com.matheusgoes.conceptual.modeling.model.State;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class StateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;
    private Set<CityDTO> cities = new HashSet<>();

    public StateDTO(State entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public StateDTO(State entity, Set<City> cities) {
        this(entity);
        cities.forEach(city -> this.cities.add(new CityDTO(city)));
    }

    public static State toEntity(StateDTO stateDTO) {
        State state = new State();
        Set<City> cities = new HashSet<>();

        BeanUtils.copyProperties(stateDTO, state);
        stateDTO.getCities().forEach(cit -> cities.add(CityDTO.toEntity(cit)));
        state.setCities(cities);

        return state;
    }
}
