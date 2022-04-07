import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  constructor() {
    obtenerDatos():Observable{
      return this.http.get('data.json');
    }
   }
}
