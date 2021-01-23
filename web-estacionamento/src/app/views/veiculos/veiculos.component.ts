import { HeaderService } from './../../components/template/header/header.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-veiculos',
  templateUrl: './veiculos.component.html',
  styleUrls: ['./veiculos.component.css']
})
export class VeiculosComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) { 
    headerService.headerData = {
        title: 'Estacionamento',
        icone: 'drive_eta',
        routeUrl:'/'
    }
  }

  ngOnInit() {
  }

  navigateToProductCreate(){
    this.router.navigate(['/entrada/form']);
  }

}
