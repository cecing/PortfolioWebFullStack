export class Experiencia {
    id? :number;
    nombreE: string;
    descripcionE: string;
    fetchInicio: string;
    fetchFin: string;

    constructor(nombreE: string, descripcionE: string, fetchInicio: string, fetchFin: string){
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fetchInicio = fetchInicio;
        this.fetchFin = fetchFin;
    }
}
