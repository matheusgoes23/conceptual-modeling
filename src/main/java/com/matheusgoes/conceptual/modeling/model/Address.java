package com.matheusgoes.conceptual.modeling.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_address")
public class Address {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publicPlace;
    private String number;
    private String complement;
    private String district;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
