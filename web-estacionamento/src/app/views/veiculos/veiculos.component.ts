import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-veiculos',
  templateUrl: './veiculos.component.html',
  styleUrls: ['./veiculos.component.css']
})
export class VeiculosComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  navigateToProductCreate(){
    this.router.navigate(['/entrada/form']);
  }

}
