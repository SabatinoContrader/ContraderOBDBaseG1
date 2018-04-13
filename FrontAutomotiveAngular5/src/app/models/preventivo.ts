import { Officina } from "./Officina";
import { Utente } from "./Utente";
import { Auto } from "./Auto";

export class Preventivo {
	id: number;
	auto: Auto;
	utente: Utente;
	officina: Officina;
	data: string;
	dettagli: string;
	stato: number;
	costo: number;
	risposta: string;
	
    constructor(id:any,auto: Auto,utente: Utente, officina: Officina, data:string,dettagli:string,stato:any,costo:number,risposta:string){
            this.id=id;
            this.auto=auto;
            this.utente=utente;
            this.officina=officina;
            this.data=data;
            this.dettagli=dettagli;
            this.stato=stato;
            this.costo=costo;
            this.risposta=risposta;
            
        }
}