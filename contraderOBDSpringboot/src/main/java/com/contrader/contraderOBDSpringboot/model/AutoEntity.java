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
    private int cod_dispositivo;

    @Column
    private String targa;

    @Column
    private int telaio;

    @Column
    private String casa_costruttrice;

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

    @Column
    private String tagliando_data;

    @Column
    private int tagliando_km;

    @ManyToOne
    @JoinColumn(name="id_driver")
    private DriverEntity driverEntity;

    @ManyToOne
    @JoinColumn(name="id_officina")
    private OfficinaEntity officinaEntity;

    @Column
    private boolean noleggiabile;

    @OneToMany
    @JoinColumn(name = "cod_dispositivo")
    private Set<DatiEntity> datiEntitySet;


}
