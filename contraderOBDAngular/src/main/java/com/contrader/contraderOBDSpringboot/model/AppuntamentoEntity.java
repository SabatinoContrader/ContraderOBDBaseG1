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
@Table(name = "appuntamento")
public class AppuntamentoEntity implements Serializable {

    @Id
    @Column(name="id_appuntamento")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAppuntamento;

    @ManyToOne
    @JoinColumn(name = "codDispositivo")
    private AutoEntity autoEntity;

    @ManyToOne
    @JoinColumn(name = "idOfficina")
    private OfficinaEntity officinaEntity;

    @ManyToOne
    @JoinColumn(name = "idDriver")
    private DriverEntity driverEntity;

    @Column
    private String descrizione;

    @Column
    private String data;

    @Column
    private Boolean stato;

}
