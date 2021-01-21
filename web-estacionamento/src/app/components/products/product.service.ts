import { map, catchError } from 'rxjs/operators';
import { Product } from './product.model';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl = 'http://localhost:3001/products'

  constructor(private snackbar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg:string, isError: boolean = false) : void {
    this.snackbar.open(msg,'X',{
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition:"top",
      panelClass: isError ? ['msg-error'] :  ['msg-success'] 
    });
  }

  create(product: Product): Observable<Product>{
    return this.http.post<Product>(this.baseUrl,product).pipe(
      map((obj) => obj),
      catchError(e => this.errorHandler(e))
    );
  }

  errorHandler (e: any): Observable<any>{
    this.showMessage('Ocorreu um erro!',true);
    return EMPTY
  }

  read(): Observable<Product[]> {
   return this.http.get<Product[]>(this.baseUrl).pipe(
    map((obj) => obj),
    catchError(e => this.errorHandler(e))
  );
  }

  readPerPage(pageIndex,pageSize): Observable<HttpResponse<Product[]>> {
   return this.http.get<Product[]>(this.baseUrl,{
     params : {
      _page :pageIndex,
      _limit:pageSize
     }, observe : 'response'
   }).pipe(
    map((obj) => obj),
    catchError(e => this.errorHandler(e))
  );
  }

  readById(id: string): Observable<Product> {
    const url = `${this.baseUrl}/${id}` ;
    return this.http.get<Product>(url)
  }

  update(product: Product): Observable<Product> {
    const url = `${this.baseUrl}/${product.id}` ;
    return this.http.put<Product>(url,product).pipe(
      map((obj) => obj),
      catchError(e => this.errorHandler(e))
    );
  }
  delete (id: number) : Observable<HttpResponse<any>> {
    const url = `${this.baseUrl}/${id}` ;
    return this.http.delete(url, {observe: 'response'}).pipe(
      map((obj) => obj),
      catchError(e => this.errorHandler(e))
    );
  }
  
}
