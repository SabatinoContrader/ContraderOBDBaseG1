import { TipologiaGuasto } from './TipologiaGuasto';
import { DatiTelemetria } from './DatiTelemetria'; 
import { Dispositivo } from './Dispositivo'; 

export class Guasto {
    private id: number;
    private tipologiaGuasto: TipologiaGuasto;
    private datiTelemetria: DatiTelemetria;
    private dispositivo: Dispositivo;
    private statoRisoluzione: string;
   


	constructor(id: number,tipologiaGuasto:TipologiaGuasto,datiTelemetria:DatiTelemetria,dispositivo:Dispositivo,statoRisoluzione:string) {
		this.id = id;
		this.tipologiaGuasto=tipologiaGuasto;
		this.datiTelemetria=datiTelemetria;
		this.dispositivo=dispositivo;
		this.statoRisoluzione=statoRisoluzione;
		
	}
        
}