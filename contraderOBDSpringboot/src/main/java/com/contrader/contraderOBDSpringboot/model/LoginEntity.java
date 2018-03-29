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
@Table(name = "login")
public class LoginEntity implements Serializable {

    @Id
    private String username;

    @Column
    private String password;

    @Column
    private int ruolo;

    @Column
    private int id;

}
