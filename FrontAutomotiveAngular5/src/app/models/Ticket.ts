import { Officina } from './Officina';
import { Utente } from './Utente'; 

export class Ticket {
    private id: number;
    private data: string;
    private oggetto: string;
    private officina: Officina;
    private utente: Utente;


	constructor(id:number,data:string,oggetto:string,officina:Officina,utente:Utente) {
		this.id = id;
		this.data = data;
		this.oggetto = oggetto;
		this.officina = officina;
		this.utente = utente;
	}
        
}