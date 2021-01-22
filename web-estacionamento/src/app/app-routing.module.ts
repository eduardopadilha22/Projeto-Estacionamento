import { RelatorioComponent } from './views/relatorio/relatorio.component';
import { CriarEntradaComponent } from './components/veiculos-entrada/criar-entrada/criar-entrada.component';
import { VeiculosComponent } from './views/veiculos/veiculos.component';
import { ProductUpdateComponent } from './components/products/product-update/product-update.component';
import { ProductCrudComponent } from './views/product-crud/product-crud.component';
import { HomeComponent } from './views/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductCreateComponent } from './components/products/product-create/product-create.component';


const routes: Routes = [{
  path: "",
  component: VeiculosComponent
},

{
  path: "entrada/form",
  component: CriarEntradaComponent
},
{
  path: "relatorio",
  component: RelatorioComponent
},
{
  path: "products/update/:id",
  component: ProductUpdateComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
