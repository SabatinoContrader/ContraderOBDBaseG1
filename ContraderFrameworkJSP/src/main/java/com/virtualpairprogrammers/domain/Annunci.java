package com.virtualpairprogrammers.domain;

public class Annunci {

    private int id;
    private String titolo;
    private String luogo;
    private String categoria;
    private String contratto;

    public Annunci() {
        super();
    }

    public Annunci(int id, String titolo, String luogo, String categoria, String contratto) {
        this.id = id;
        this.titolo = titolo;
        this.luogo = luogo;
        this.categoria = categoria;
        this.contratto = contratto;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContratto() {
        return contratto;
    }

    public void setContratto(String contratto) {
        this.contratto = contratto;
    }

}

