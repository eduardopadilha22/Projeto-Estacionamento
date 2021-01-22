import { VeiculosService } from './../veiculos.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Veiculo } from '../veiculo.model';

@Component({
  selector: 'app-criar-entrada',
  templateUrl: './criar-entrada.component.html',
  styleUrls: ['./criar-entrada.component.css']
})
export class CriarEntradaComponent implements OnInit {
  veiculo : Veiculo = {
    placa: '',
    modelo: '',
    cor: ''
  }
  constructor(private router: Router, private veiculosService : VeiculosService) { }

  ngOnInit() {
  }

  salvarVeiculo(): void {
    this.veiculosService.salvarVeiculoUsingPost(this.veiculo).subscribe(resp => {
      console.log(resp);
      this.veiculosService.showMessage('Entrada feita com Sucesso')
      this.router.navigate(['/'])
    }, err => {
      this.veiculosService.showMessage(err.error.message, true)
    })
  }

  cancelar(): void {
    this.router.navigate(['/'])
  }
  
}
