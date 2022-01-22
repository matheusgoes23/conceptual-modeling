package com.matheusgoes.conceptual.modeling.dto;

import com.matheusgoes.conceptual.modeling.model.Address;
import com.matheusgoes.conceptual.modeling.model.City;
import com.matheusgoes.conceptual.modeling.model.Client;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String publicPlace;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
    private String district;

    @NotBlank
    private String zipCode;

    @NotNull
    private ClientDTO client;

    @NotNull
    private CityDTO city;

    public AddressDTO(Address entity) {
        id = entity.getId();
        publicPlace = entity.getPublicPlace();
        number = entity.getNumber();
        complement = entity.getComplement();
        district = entity.getDistrict();
        zipCode = entity.getZipCode();
        city = new CityDTO(entity.getCity());
    }

    public AddressDTO(Address entity, Client client) {
        id = entity.getId();
        publicPlace = entity.getPublicPlace();
        number = entity.getNumber();
        complement = entity.getComplement();
        district = entity.getDistrict();
        zipCode = entity.getZipCode();
        this.client = new ClientDTO(client);
        city = new CityDTO(entity.getCity());
    }

    public static Address toEntity(AddressDTO addressDTO) {
        Address address = new Address();
        Client client = ClientDTO.toEntity(addressDTO.getClient());
        City city = CityDTO.toEntity(addressDTO.getCity());

        BeanUtils.copyProperties(addressDTO, address);
        address.setClient(client);
        address.setCity(city);

        return address;
    }
}
