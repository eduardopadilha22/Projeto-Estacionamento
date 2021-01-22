import { Veiculo } from './veiculo.model';
import { VeiculosService } from './veiculos.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material';

@Component({
  selector: 'app-veiculos-entrada',
  templateUrl: './veiculos-entrada.component.html',
  styleUrls: ['./veiculos-entrada.component.css']
})
export class VeiculosEntradaComponent implements OnInit {
  veiculosEstacionados : Veiculo[]


  displayedColumns = ['id', 'placa','modelo','cor','horaEntrada','statusVehicle','action'];

  constructor(private veiculosService: VeiculosService) { }

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

}
