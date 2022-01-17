package com.matheusgoes.conceptual.modeling.model;

import com.matheusgoes.conceptual.modeling.enums.ClientType;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_client")
public class Client {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String cpfOrCnpj;
    private ClientType type;

    @OneToMany(mappedBy = "client")
    private Set<Address> addresses = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "tb_telephone")
    private Set<String> phones = new HashSet<>();
}
