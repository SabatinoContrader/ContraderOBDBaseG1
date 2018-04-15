import { Ticket } from './Ticket';


export class Messaggio {
    private id: number;
    private data: string;
    private direzione: number;
    private ticket: Ticket;
    private testo: string;


	constructor(id: number, data: string, direzione:number,ticket:Ticket,testo:string) {
		this.id = id;
		this.data = data;
		this.direzione=direzione;
		this.ticket=ticket;
		this.testo=testo;
	}
        
}