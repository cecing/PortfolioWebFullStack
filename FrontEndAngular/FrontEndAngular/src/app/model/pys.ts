export class Pys {
    id? :number;
    nombreP: string;
    descripcionP: string;
    fetchP: string;
    herrams: string;
    enlace: string;

    constructor(nombreP: string, descripcionP: string, fetchP: string, herrams: string, enlace:string){
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.fetchP = fetchP;
        this.herrams = herrams;
        this.enlace = enlace;
}
}
