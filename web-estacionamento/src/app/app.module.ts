
import { BreakPointRegistry, FlexLayoutModule, FlexOrderStyleBuilder, FlexStyleBuilder, LayoutStyleBuilder, MediaMarshaller, PrintHook, ShowHideStyleBuilder, StylesheetMap, StyleUtils } from '@angular/flex-layout';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/template/header/header.component';

import { MatToolbarModule} from '@angular/material/toolbar';
import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component';

import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from'@angular/material/list';
import { MatCardModule } from'@angular/material/card';
import { MatButtonModule } from'@angular/material/button';
import { MatSnackBarModule } from'@angular/material/snack-bar';
import { MatDialogModule } from'@angular/material/dialog';
import { MatDatepickerModule, MatNativeDateModule } from '@angular/material';

import  { HttpClientModule } from '@angular/common/http'

import { FormsModule } from '@angular/forms';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule} from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import localePt from '@angular/common/locales/pt';
import { registerLocaleData} from '@angular/common';
import { VeiculosComponent } from './views/veiculos/veiculos.component';
import { VeiculosEntradaComponent } from './components/veiculos-entrada/veiculos-entrada.component';
import { CriarEntradaComponent } from './components/veiculos-entrada/criar-entrada/criar-entrada.component';
import { DialogRetirarComponent } from './components/veiculos-entrada/dialog-retirar/dialog-retirar.component';
import { RelatorioComponent } from './views/relatorio/relatorio.component';
import { IConfig, NgxMaskModule } from 'ngx-mask';

export const options: Partial<IConfig> | (() => Partial<IConfig>) = {};

registerLocaleData(localePt);

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    VeiculosComponent,
    VeiculosEntradaComponent,
    CriarEntradaComponent,
    DialogRetirarComponent,
    RelatorioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatDialogModule,
    FlexLayoutModule,
    MatDatepickerModule,        // <----- import(must)
    MatNativeDateModule,        // <----- import for date formating(optional)
    NgxMaskModule.forRoot(options)
  ],
  entryComponents: [DialogRetirarComponent],
  providers: [
    PrintHook,
    StyleUtils, 
    StyleSheet,
    StylesheetMap, 
    LayoutStyleBuilder,
    FlexStyleBuilder,
    BreakPointRegistry,
    MediaMarshaller,
    {
    provide: LOCALE_ID,
    useValue: 'pt-BR'
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
