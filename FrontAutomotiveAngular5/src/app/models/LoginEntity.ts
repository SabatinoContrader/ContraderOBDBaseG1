import { Auto } from "./Auto";
import { Utente } from "./Utente";

export class LoginEntity {

    listaAuto: Auto[];
    numGuasti: number;
    numKmNoleggio:number;
    numScadenze:number;
    utente: Utente;

    constructor(listaAuto:Auto[],numGuasti:number,numKmNoleggio:number,numScadenze:number,utente:Utente){
        this.listaAuto=listaAuto;
        this.numGuasti=numGuasti;
        this.numKmNoleggio=numKmNoleggio;
        this.numScadenze=numScadenze;
        this.utente=utente;
    }
}