package com.matheusgoes.conceptual.modeling.dto;

import com.matheusgoes.conceptual.modeling.model.City;
import com.matheusgoes.conceptual.modeling.model.State;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class CityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;
    private StateDTO state;

    public CityDTO(City entity) {
        id = entity.getId();
        name = entity.getName();
        state = new StateDTO(entity.getState());
    }

    public static City toEntity(CityDTO cityDTO) {
        City city = new City();
        State state = StateDTO.toEntity(cityDTO.getState());
        BeanUtils.copyProperties(cityDTO, city);
        city.setState(state);
        return city;
    }
}
