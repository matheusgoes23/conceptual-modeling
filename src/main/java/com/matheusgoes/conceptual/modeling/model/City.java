package com.matheusgoes.conceptual.modeling.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_city")
public class City {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
