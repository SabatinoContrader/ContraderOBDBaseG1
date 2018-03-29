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
    private long id_officina;

    @Column
    private String nome_officina;

    @Column
    private String indirizzo;

    @Column
    private String citta;

    @OneToMany
    @JoinColumn(name = "id_officina")
    private Set<AutoEntity> autoEntitySet;


}



