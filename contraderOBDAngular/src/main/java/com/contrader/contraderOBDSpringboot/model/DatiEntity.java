package com.contrader.contraderOBDSpringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dati_dispositivo")
public class DatiEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int n;

    @ManyToOne
    @JoinColumn(name = "codDispositivo")
    private AutoEntity autoEntity;

    @Column
    private String data;

    @Column
    private int km;

    @Column(name="livello_olio")
    private float livelloOlio;

    @Column(name="cod_errore")
    private String codErrore;

    @Column
    private boolean stato;

}
