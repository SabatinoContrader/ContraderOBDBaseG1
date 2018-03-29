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
    @Column(name="id_driver")
    private int idDriver;

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
    @JoinColumn(name = "idAzienda")
    private AziendaEntity aziendaEntity;

    @OneToMany
    @JoinColumn(name = "idDriver")
    private Set<AutoEntity> autoEntitySet;

}
