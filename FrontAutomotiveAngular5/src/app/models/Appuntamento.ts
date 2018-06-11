import { Officina } from './Officina';
import { Utente } from './Utente'; 

export class Appuntamento {
    private id: number;
    private data: string;
    private dettagli: string;
    private ora: string;
    private risposta: string;
    private stato: number;
    private officina: Officina;
    private utente: Utente;


	constructor($id: number, $data: string, $dettagli: string, $ora: string, $risposta: string, $stato: number, $officina: Officina, $utente: Utente) {
		this.id = $id;
		this.data = $data;
		this.dettagli = $dettagli;
		this.ora = $ora;
		this.risposta = $risposta;
		this.stato = $stato;
		this.officina = $officina;
		this.utente = $utente;
	}
        
}