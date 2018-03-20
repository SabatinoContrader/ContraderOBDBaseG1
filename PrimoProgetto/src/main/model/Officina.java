package main.model;

public class Officina {
    private String Nome_Officina;
    private String Indirizzo;
    private String Città;

    public Officina (String Nome_Officina, String Indirizzo, String Città){
        this.Nome_Officina = Nome_Officina;
        this.Indirizzo = Indirizzo;
        this.Città = Città;
    }

    public String getNome_Officina() {
        return Nome_Officina;
    }

    public void setNome_Officina(String nome_Officina) {
        this.Nome_Officina = nome_Officina;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.Indirizzo = indirizzo;
    }

    public String getCittà() {
        return Città;
    }

    public void setCittà(String nome_Città) {
        this.Città = Città;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Officina officina = (Officina) o;

        if (Nome_Officina != null ? !Nome_Officina.equals(officina.Nome_Officina) : officina.Nome_Officina != null)
            return false;
        if (Indirizzo != null ? !Indirizzo.equals(officina.Indirizzo) : officina.Indirizzo != null) return false;
        return Città != null ? Città.equals(officina.Città) : officina.Città == null;
    }

    @Override
    public int hashCode() {
        int result = Nome_Officina != null ? Nome_Officina.hashCode() : 0;
        result = 31 * result + (Indirizzo != null ? Indirizzo.hashCode() : 0);
        result = 31 * result + (Città != null ? Città.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Officina{" +
                "Nome_Officina='" + Nome_Officina + '\'' +
                ", Indirizzo='" + Indirizzo + '\'' +
                ", Nome_Città='" + Città + '\'' +
                '}';
    }
}