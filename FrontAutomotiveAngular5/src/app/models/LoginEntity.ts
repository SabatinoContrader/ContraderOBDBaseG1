import { Auto } from "./Auto";
import { Utente } from "./Utente";

export class LoginEntity {

    statoAuto: any;
    numGuasti: number;
    numKmNoleggio:number;
    numScadenze:number;
    utente: Utente;

    constructor(statoAuto:any,numGuasti:number,numKmNoleggio:number,numScadenze:number,utente:Utente){
        this.statoAuto=statoAuto;
        this.numGuasti=numGuasti;
        this.numKmNoleggio=numKmNoleggio;
        this.numScadenze=numScadenze;
        this.utente=utente;
    }
}