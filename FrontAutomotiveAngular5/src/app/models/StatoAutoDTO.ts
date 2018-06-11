import { Auto } from "./Auto";

export class StatoAutoDTO {
    auto: Auto;
    status: string;


    constructor(auto: Auto, status: string){
        this.auto = auto;
        this.status = status;
        }
}