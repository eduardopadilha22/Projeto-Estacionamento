import { ExitPayment } from './../exitPayment.model';
import { VeiculosService } from './../veiculos.service';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-dialog-retirar',
  templateUrl: './dialog-retirar.component.html',
  styleUrls: ['./dialog-retirar.component.css']
})
export class DialogRetirarComponent implements OnInit {
  id_vehicle: Number;
  placa: String;
  payment: ExitPayment
  constructor(
    @Inject(MAT_DIALOG_DATA)
    public data: any,public dialogRef: MatDialogRef<DialogRetirarComponent>
  ) { }

  ngOnInit() {

   this.payment =  this.data.exitPayment;
    
  }

}
