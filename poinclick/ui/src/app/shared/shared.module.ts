import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TemplateComponent} from '../template/template.component';
import {FooterComponent} from './footer/footer.component';
import {HeaderComponent} from './header/header.component';
import {MenuComponent} from './menu/menu.component';
import {RightSidebarComponent} from './right-sidebar/right-sidebar.component';
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToastrModule} from "ngx-toastr";
import {NgxPaginationModule} from "ngx-pagination";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatDialogModule} from "@angular/material/dialog";
import {MatIconModule} from "@angular/material/icon";
import {MatSortModule} from "@angular/material/sort";
import {MatMenuModule} from "@angular/material/menu";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxMatSelectSearchModule} from "ngx-mat-select-search";
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    FooterComponent,
    HeaderComponent,
    MenuComponent,
    RightSidebarComponent
  ],
  exports: [
    CommonModule,
    FooterComponent,
    HeaderComponent,
    MenuComponent,
    RightSidebarComponent,
    MatInputModule,
    MatFormFieldModule,
    NgxPaginationModule,
    HttpClientModule,
    MatButtonModule,
    MatTableModule,
    MatToolbarModule,
    MatDialogModule,
    MatIconModule,
    MatSortModule,
    MatMenuModule,
    MatDatepickerModule,
    MatPaginatorModule,
    MatOptionModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,
    NgxMatSelectSearchModule,
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class SharedModule { }
