import { Auto } from './Auto';
import { Posizione } from './Posizione';

export class AutoLocation {
    auto: Auto;
    posizione: Posizione;

    constructor(auto: Auto, posizione: Posizione) {
        this.auto = auto;
        this.posizione = posizione;
    }

}