import { Officina } from "./Officina";

export class Auto {
    alimentazione:string;
    cilindrata:number;
    daNoleggio:number;
    id:number
    kmAttuali:number;
    kmInizioNoleggio:number;
    marca:string;
    modello:string;
    numeroPorte:number;
    numeroTelaio:string;
    officina:Officina;
    scadenzaAssicurazione:number
    scadenzaBollo:number
    scadenzaRevisione:number
    scadenzaTagliando:number
    targa:string
    tipologiaAuto:string


    constructor(alimentazione:string,cilindrata:number,daNoleggio:number,id:number,kmAttuali:number,
        kmInizioNoleggio:number,marca:string,modello:string,numeroPorte:number,numeroTelaio:string,
        officina:Officina,scadenzaAssicurazione:number,scadenzaBollo:number,scadenzaRevisione:number,
        scadenzaTagliando:number,targa:string,tipologiaAuto:string){
            this.alimentazione=alimentazione;
            this.cilindrata=cilindrata;
            this.daNoleggio=daNoleggio;
            this.id=id;
            this.kmAttuali=kmAttuali;
            this.kmInizioNoleggio=kmInizioNoleggio;
            this.marca=marca;
            this.modello=modello;
            this.numeroPorte=numeroPorte;
            this.numeroTelaio=numeroTelaio;
            this.officina=officina;
            this.scadenzaAssicurazione=scadenzaAssicurazione;
            this.scadenzaBollo=scadenzaBollo;
            this.scadenzaRevisione=scadenzaRevisione;
            this.scadenzaTagliando=scadenzaTagliando;
            this.targa=targa;
            this.tipologiaAuto=tipologiaAuto;
        }
}