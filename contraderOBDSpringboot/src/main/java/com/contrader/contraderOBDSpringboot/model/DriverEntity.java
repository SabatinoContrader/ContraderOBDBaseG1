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
@Table(name = "driver")
public class DriverEntity implements Serializable {

    @Id
    private int id_driver;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private String cf;

    @Column
    private String email;

    @Column
    private String cellulare;

    @Column
    private String residenza;

    @ManyToOne
    @JoinColumn(name = "id_azienda")
    private AziendaEntity aziendaEntity;

    @OneToMany
    @JoinColumn(name = "id_driver")
    private Set<AutoEntity> autoEntitySet;

}
