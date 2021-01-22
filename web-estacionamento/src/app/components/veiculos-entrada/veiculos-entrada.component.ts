import { DialogRetirarComponent } from './dialog-retirar/dialog-retirar.component';
import { Veiculo } from './veiculo.model';
import { VeiculosService } from './veiculos.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatPaginator, PageEvent } from '@angular/material';
import { ExitPayment } from './exitPayment.model';

@Component({
  selector: 'app-veiculos-entrada',
  templateUrl: './veiculos-entrada.component.html',
  styleUrls: ['./veiculos-entrada.component.css']
})
export class VeiculosEntradaComponent implements OnInit {
  veiculosEstacionados : Veiculo[]
  id_vehicle: Number;
  placa: String;
  payment: ExitPayment


  displayedColumns = ['id', 'placa','modelo','cor','horaEntrada','statusVehicle','action'];

  constructor(private veiculosService: VeiculosService, private matDialog: MatDialog) { }

  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  pageSize =5;
  pageIndex = 1;

  ngOnInit() {
    this.getVeiculosEstacionados();
  }

  loadingPage(event: PageEvent){
    this.pageSize = event.pageSize;
    this.pageIndex = event.pageIndex+1;
    
  }

  getVeiculosEstacionados(){
    return this.veiculosService.veiculosEstacionadosUsingPost(this.pageIndex,this.pageSize).subscribe(resp => {
      this.veiculosEstacionados = resp.content;
      this.paginator.length = resp.totalElements;
    })
  }



  openDialog(exitPayment: ExitPayment){
    const dialogRef =  this.matDialog.open(DialogRetirarComponent, {
      data :{
        exitPayment
      }
    })
 
    dialogRef.afterClosed().subscribe(result => {
       if(result === 'success'){
         this.getVeiculosEstacionados();
       }
    });
   }

   retirarVeiculo(id_veiculo, placa){
    this.veiculosService.retirarVeiculoUsingPost(id_veiculo, placa).subscribe(resp => {
      this.payment = resp;
      this.veiculosService.showMessage('Retirada Feita com Sucesso');
      this.openDialog(this.payment)
    }, err => {

      this.veiculosService.showMessage(err.error.message, true);
    });
}

}
