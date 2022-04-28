import {NgModule} from '@angular/core';

import {TemplateRoutingModule} from './template-routing.module';
import {TemplateComponent} from './template.component';
import {SharedModule} from '../shared/shared.module';
import {MatConfirmDialogComponent} from "../mat-confirm-dialog/mat-confirm-dialog.component";
import { AnneesComponent } from '../components/annees/annees.component';
import { MoisComponent } from '../components/mois/mois.component';
import { JourneeComponent } from '../components/journee/journee.component';
import { DetailJourneeComponent } from '../components/detail-journee/detail-journee.component';
import { PersonnelComponent } from '../components/personnel/personnel.component';
import { ExercieComponent } from '../components/exercie/exercie.component';
import { SuiviComponent } from '../components/suivi/suivi.component';


@NgModule({
  declarations: [
    TemplateComponent,
    AnneesComponent,
    MatConfirmDialogComponent, 
    MoisComponent,
    JourneeComponent,
    DetailJourneeComponent,
    PersonnelComponent,
    ExercieComponent,
    SuiviComponent
  ],
  imports: [
    TemplateRoutingModule,
    SharedModule
  ]
})
export class TemplateModule { }
