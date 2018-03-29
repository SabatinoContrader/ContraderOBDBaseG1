package com.virtualpairprogrammers.domain;

import java.util.Objects;

public class Driver {

    private int id;
    private String nome;
    private String cognome;
    private String cf;
    private String email;
    private String cellulare;
    private String residenza;
    private Integer id_azienda;

    public Driver(int id, String nome, String cognome, String cf, String email, String cellulare, String residenza, Integer id_azienda) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.email = email;
        this.cellulare = cellulare;
        this.residenza = residenza;
        this.id_azienda = id_azienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public Integer getId_azienda() {
        return id_azienda;
    }

    public void setId_azienda(Integer id_azienda) {
        this.id_azienda = id_azienda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return id == driver.id &&
                Objects.equals(nome, driver.nome) &&
                Objects.equals(cognome, driver.cognome) &&
                Objects.equals(cf, driver.cf) &&
                Objects.equals(email, driver.email) &&
                Objects.equals(cellulare, driver.cellulare) &&
                Objects.equals(residenza, driver.residenza) &&
                Objects.equals(id_azienda, driver.id_azienda);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, cognome, cf, email, cellulare, residenza, id_azienda);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", cf='" + cf + '\'' +
                ", email='" + email + '\'' +
                ", cellulare='" + cellulare + '\'' +
                ", residenza='" + residenza + '\'' +
                ", id_azienda=" + id_azienda +
                '}';
    }
}
