export class Azienda {
    id: number;
    denominazione: string;
    nomeReferente: string;
    cognomeReferente: string;
    partitaIva: string;
    indirizzo: string;
    citta: string;
    constructor(id: number, denominazione: string, nomeReferente: string, cognomeReferente: string, partitaIva: string,
        indirizzo: string, citta: string) {
        this.id=id;
        this.denominazione=denominazione;
        this.nomeReferente=nomeReferente;
        this.cognomeReferente=cognomeReferente;
        this.partitaIva=partitaIva;
        this.indirizzo=indirizzo;
        this.citta=citta;
    }
}