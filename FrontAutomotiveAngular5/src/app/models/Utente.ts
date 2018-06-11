import { Officina } from "./Officina";
import { Azienda } from "./Azienda";

export class Utente {

    cognome: string;
    dataRegistrazione: number;
    email: string;
    id: number;
    nome: string;
    officina: Officina;
    password: string
    ruolo: number;
    stato: number;
    telefono: string;
    azienda:Azienda;
    citta:string

    constructor(cognome: string, dataRegistrazione: number, email: string, id: number, nome: string, officina: Officina,
        password: string, ruolo: number, stato: number, telefono: string,azienda:Azienda,citta:string) {
        this.cognome = cognome;
        this.dataRegistrazione = dataRegistrazione;
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.officina = officina;
        this.password = password;
        this.ruolo = ruolo;
        this.stato = stato;
        this.telefono = telefono;
        this.azienda= azienda;
        this.citta=citta;
    }
}