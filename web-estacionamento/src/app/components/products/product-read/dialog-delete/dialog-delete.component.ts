import { ProductService } from './../../product.service';
import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-dialog-delete',
  templateUrl: './dialog-delete.component.html',
  styleUrls: ['./dialog-delete.component.css']
})
export class DialogDeleteComponent implements OnInit {
  idProduct: number;
  constructor(
    @Inject(MAT_DIALOG_DATA)
    public data: any, private productService: ProductService,public dialogRef: MatDialogRef<DialogDeleteComponent>) { }
  ngOnInit() {
    this.idProduct = this.data.id;
  }
  deleteProduct(): void {
    this.productService.delete(this.idProduct).subscribe(result => {
      if (result.status === 200 || result.status === 201) {
        this.dialogRef.close('success');
        this.productService.showMessage('Item Removido com Sucesso!');
      }
    });
  }
}


