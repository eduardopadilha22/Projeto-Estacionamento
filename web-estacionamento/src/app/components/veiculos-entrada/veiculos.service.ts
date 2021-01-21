import { Observable } from 'rxjs';
import { Veiculo } from './veiculo.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VeiculosService {
   baseUrl = "http://localhost:8080/api/vehicle";

  constructor(private http: HttpClient) {

   }

   salvarVeiculoUsingPost(veiculo: Veiculo): Observable<Veiculo>{
      return this.http.post(this.baseUrl,veiculo);
  }

}
