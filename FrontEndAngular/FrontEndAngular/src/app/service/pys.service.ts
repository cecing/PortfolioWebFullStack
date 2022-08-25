import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pys } from '../model/pys';

@Injectable({
  providedIn: 'root'
})
export class PysService {
  URL = 'http://localhost:8080/pys/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Pys[]>{
    return this.httpClient.get<Pys[]>(this.URL + 'lista');
  }

  public detail(id:number): Observable<Pys>{
    return this.httpClient.get<Pys>(this.URL + `detail/${id}`);
  }
   
  public save(pys: Pys): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', pys);
  }

  public update(id: number,pys: Pys): Observable<any>{
    return this.httpClient.put<any>(this.URL + `update/${id}`, pys);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
}
