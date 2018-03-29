package com.contrader.contraderOBDSpringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "azienda")
public class AziendaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_azienda;

    @Column
    private String nome;

    @Column
    private String citta;

    @OneToMany
    @JoinColumn(name = "id_azienda")
    private Set<DriverEntity> driverEntitySet;

}
