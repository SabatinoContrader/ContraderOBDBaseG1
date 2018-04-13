import { Officina } from './Officina';
import { Auto } from './Auto'; 

export class Dispositivo {
    private id: number;
    private codice: string;
    private auto: Auto;
    private dataInstallazione: string;
    private officina: Officina;
   


	constructor(id: number,codice:string,auto:Auto,dataInstallazione:string,officina:Officina) {
		this.id = id;
		this.codice = codice;
		this.auto = auto;
		this.dataInstallazione = dataInstallazione;
		this.officina = officina;
		
	}
        
}