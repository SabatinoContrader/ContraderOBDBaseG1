package main.model;

public class Azienda {
    String nomeAzienda;
    String Città;

    public Azienda(){}

    public Azienda(String nomeAzienda, String Città){
        this.nomeAzienda = nomeAzienda;
        this.Città = Città;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Azienda azienda = (Azienda) o;

        if (!azienda.Città.equals(Città)) return false;
        if (!azienda.nomeAzienda.equals(nomeAzienda)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = nomeAzienda != null ? nomeAzienda.hashCode() : 0;
        result = 31 * result + (Città != null ? Città.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Nome Azienda: " + nomeAzienda + "\nNome città: " +Città +"\n";
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public void setCittà(String Città) {
        this.Città = Città;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public String getCittà() {
        return Città;
    }
}
