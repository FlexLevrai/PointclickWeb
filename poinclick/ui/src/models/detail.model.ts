import { Journee } from "./journee.model";
import { Personnel } from "./Personnel.model";


export class DetailJourneeModel {
    id:number;
    heureArrive: string;
    heureDepart: string;
    heureDebutPause: string;
    heureFinPause: string;
    heureSortieSpeciale: Date;
    motif: string;
    finHeureSortieSpeciale: Date;
    dateJour: Date;
    journee: Journee = new Journee();
    personnel: Personnel = new Personnel();
}