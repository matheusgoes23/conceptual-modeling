package com.matheusgoes.conceptual.modeling.dto;

import com.matheusgoes.conceptual.modeling.enums.ClientType;
import com.matheusgoes.conceptual.modeling.model.Address;
import com.matheusgoes.conceptual.modeling.model.Client;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String cpfOrCnpj;

    @NotNull
    private ClientType type;

    private Set<AddressDTO> addresses = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        cpfOrCnpj = entity.getCpfOrCnpj();
        type = entity.getType();
        phones = entity.getPhones();
    }

    public ClientDTO(Client entity, Set<Address> addresses) {
        this(entity);
        addresses.forEach(address -> this.addresses.add(new AddressDTO(address)));
    }

    public static Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        Set<Address> addresses = new HashSet<>();

        BeanUtils.copyProperties(clientDTO, client);
        clientDTO.getAddresses().forEach(addre -> addresses.add(AddressDTO.toEntity(addre)));
        client.setAddresses(addresses);

        return client;
    }
}
