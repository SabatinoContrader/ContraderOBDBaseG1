export class Officina {
    citta: string;
    cognomeReferente: string
    dataInserimento: number;
    denominazione: string;
    email: string;
    id: number;
    indirizzo: string;
    nomeReferente: string
    telefono: string;


    constructor( citta: string,cognomeReferente: string,dataInserimento: number,denominazione: string,
        email: string,id: number,indirizzo: string,nomeReferente: string,telefono: string) {
            this.email=email;
            this.cognomeReferente=cognomeReferente;
            this.dataInserimento=dataInserimento;
            this.denominazione=denominazione;
            this.email=email;
            this.id=id;
            this.indirizzo=indirizzo;
            this.nomeReferente=nomeReferente;
            this.telefono=telefono;
    }
}