package main.model;

public class Azienda {
    String nomeAzienda;
    String nomeCittà;

    public Azienda(){}

    public Azienda(String nomeAzienda, String nomeCittà){
        this.nomeAzienda = nomeAzienda;
        this.nomeCittà = nomeCittà;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Azienda azienda = (Azienda) o;

        if (!azienda.nomeCittà.equals(nomeCittà)) return false;
        if (!azienda.nomeAzienda.equals(nomeAzienda)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = nomeAzienda != null ? nomeAzienda.hashCode() : 0;
        result = 31 * result + (nomeCittà != null ? nomeCittà.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Nome Azienda: " + nomeAzienda + "\nNome città: " +nomeCittà +"\n";
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public void setNomeCittà(String nomeCittà) {
        this.nomeCittà = nomeCittà;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public String getNomeCittà() {
        return nomeCittà;
    }
}
