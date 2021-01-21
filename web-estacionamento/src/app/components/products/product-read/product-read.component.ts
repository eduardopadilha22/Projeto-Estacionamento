import { DialogDeleteComponent } from './dialog-delete/dialog-delete.component';
import { ProductService } from './../product.service';
import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Product } from '../product.model';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
@Component({
  selector: 'app-product-read',
  templateUrl: './product-read.component.html',
  styleUrls: ['./product-read.component.css']
})
export class ProductReadComponent implements OnInit {
  products: Product[]
  total: number;
  constructor(private productService: ProductService, private matDialog: MatDialog) { }
 
  
  displayedColumns = ['id', 'name','price','Action'];

  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  pageSize =5;
  pageIndex = 1;

  ngOnInit() {
   this.getProducts();
  }



  loadingPage(event: PageEvent){
    this.pageSize = event.pageSize;
    this.pageIndex = event.pageIndex+1;
    
    this.getProducts();
  }

  getProducts(){

    this.productService.readPerPage(this.pageIndex,this.pageSize).subscribe(data => {
      this.products = data.body;
    
      this.paginator.length = parseInt(data.headers.get('X-Total-Count'),10);
      
    });
  }

  openDialog(id){
   const dialogRef =  this.matDialog.open(DialogDeleteComponent, {
     data :{
       id : id,
       height: '200px',
       width: '600px',
     }
   })

   dialogRef.afterClosed().subscribe(result => {
      if(result === 'success'){
        this.getProducts();
      }
   });
  }

  

}
