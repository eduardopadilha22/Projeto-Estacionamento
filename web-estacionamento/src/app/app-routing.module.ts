import { RelatorioComponent } from './views/relatorio/relatorio.component';
import { CriarEntradaComponent } from './components/veiculos-entrada/criar-entrada/criar-entrada.component';
import { VeiculosComponent } from './views/veiculos/veiculos.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


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
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
