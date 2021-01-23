import { VeiculosService } from './../../components/veiculos-entrada/veiculos.service';
import { ExitPayment } from './../../components/veiculos-entrada/exitPayment.model';
import { Component, OnInit } from '@angular/core';
import { HeaderService } from 'src/app/components/template/header/header.service';

@Component({
  selector: 'app-relatorio',
  templateUrl: './relatorio.component.html',
  styleUrls: ['./relatorio.component.css']
})
export class RelatorioComponent implements OnInit {
  inicio : ''
  fim : ''
  payment: ExitPayment[]

  displayedColumns = ['placa', 'modelo','cor','horaEntrada','horaSaida','totalPagamento'];

  constructor(private veiculosService: VeiculosService,private headerService: HeaderService) {
    headerService.headerData = {
      title: 'Relatório',
      icone: 'assignment',
      routeUrl:'/relatorio'
  }
   }

  ngOnInit() {
  }


  gerarRelatorio(){
      this.veiculosService.gerarRelatorio(this.inicio,this.fim).subscribe(resp => {
          this.payment = resp;
          this.veiculosService.showMessage("Relatório Gerado com Sucesso");
      }, err => {
          this.veiculosService.showMessage(err.error.message,true);
      })
  }

}
