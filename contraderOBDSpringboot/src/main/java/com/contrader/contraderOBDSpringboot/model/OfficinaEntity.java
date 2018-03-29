package com.contrader.contraderOBDSpringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "officina")
public class OfficinaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_officina")
    private long idOfficina;

    @Column(name="nome_officina")
    private String nomeOfficina;

    @Column
    private String indirizzo;

    @Column
    private String citta;

    @OneToMany
    @JoinColumn(name = "idOfficina")
    private Set<AutoEntity> autoEntitySet;


}



