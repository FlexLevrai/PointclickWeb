import { DetailJourneeModel } from "./detail.model";


export class ExerciceJournalierModel {
    id: number;
    heureArrive: Date;
    heureDebutPause: Date;
    heureFinPause: Date;
    heureDepart: Date;
    detailJournee: DetailJourneeModel = new DetailJourneeModel();
}