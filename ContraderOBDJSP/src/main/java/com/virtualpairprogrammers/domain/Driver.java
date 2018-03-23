package com.virtualpairprogrammers.domain;

public class Driver {

    private int id;
    private String nome;
    private String cognome;
    private String cf;
    private String residenza;

    public Driver(String nome, String cognome, String cf, String residenza, int id){
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.residenza = residenza;
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (!driver.nome.equals(nome)) return false;
        if (!driver.cognome.equals(cognome)) return false;
        if (!driver.cf.equals(cf)) return false;
        if (!driver.residenza.equals(residenza)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (cognome != null ? cognome.hashCode() : 0);
        result = 63 * result + (cf != null ? cf.hashCode() : 0);
        result = 94 * result + (residenza != null ? residenza.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Nome Deiver: " + nome + "\nCognome Driver: " +cognome +"\n";
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCf() {
        return cf;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
