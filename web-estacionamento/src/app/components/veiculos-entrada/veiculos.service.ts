import { ExitPayment } from './exitPayment.model';
import { Observable } from 'rxjs';
import { Veiculo } from './veiculo.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class VeiculosService {
   baseUrl = "http://localhost:8081/api";
  // baseUrl = "http://192.168.99.100:8081/api"; 

  constructor(private snackbar: MatSnackBar ,private http: HttpClient) {

   }

   showMessage(msg:string, isError: boolean = false) : void {
    this.snackbar.open(msg,'X',{
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition:"top",
      panelClass: isError ? ['msg-error'] :  ['msg-success'] 
    });
  }

   salvarVeiculoUsingPost(veiculo: Veiculo): Observable<Veiculo>{
      return this.http.post(`${this.baseUrl}/vehicle`,veiculo);
  }

   veiculosEstacionadosUsingPost(pageIndex, limitIndex): Observable<any> {
      return this.http.get(`${this.baseUrl}/vehicle`,{
        params: {
          page: pageIndex,
          limit: limitIndex
        }
      })
   }

   retirarVeiculoUsingPost(id_vehicle: Number, placa : String ): Observable<any>{
      return this.http.post(`${this.baseUrl}/payment/${placa}/${id_vehicle}`, null );
   }

   gerarRelatorio(data_inicial, data_final): Observable<any> {
     return this.http.get(`${this.baseUrl}/report`, {
       params: {
        dataInicial: data_inicial,
        dataFinal: data_final
       }
     });
   }

}
