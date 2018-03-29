package com.contrader.contraderOBDSpringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Driver;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "automobile")
public class AutoEntity implements Serializable {

    @Id
    @Column(name = "cod_dispositivo")
    private int codDispositivo;

    @Column
    private String targa;

    @Column
    private int telaio;

    @Column(name = "casa_costruttrice")
    private String casaCostruttrice;

    @Column
    private String modello;

    @Column
    private String alimentazione;

    @Column
    private String tipologia;

    @Column
    private char cambio;

    @Column
    private String proprietario;

    @Column
    private String revisione;

    @Column(name = "tagliando_data")
    private String tagliandoData;

    @Column(name = "tagliando_km")
    private int tagliandoKm;

    @ManyToOne
    @JoinColumn(name="idDriver")
    private DriverEntity driverEntity;

    @ManyToOne
    @JoinColumn(name="idOfficina")
    private OfficinaEntity officinaEntity;

    @Column
    private boolean noleggiabile;

    @OneToMany
    @JoinColumn(name = "codDispositivo")
    private Set<DatiEntity> datiEntitySet;


}
