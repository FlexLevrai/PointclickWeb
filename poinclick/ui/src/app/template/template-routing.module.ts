import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnneesComponent } from '../components/annees/annees.component';
import { DashboardComponent } from '../components/dashboard/dashboard.component';
import { DetailJourneeComponent } from '../components/detail-journee/detail-journee.component';
import { ExercieComponent } from '../components/exercie/exercie.component';
import { JourneeComponent } from '../components/journee/journee.component';
import { MoisComponent } from '../components/mois/mois.component';
import { PersonnelComponent } from '../components/personnel/personnel.component';
import { SuiviComponent } from '../components/suivi/suivi.component';
import {TemplateComponent} from "./template.component";

const routes: Routes = [

  {
    path: '',
    component: TemplateComponent,
    children: [
      {path: 'dashboard', component: DashboardComponent},
      {path: 'annees', component: AnneesComponent},
      {path: 'mois', component: MoisComponent},
      {path: 'journee', component: JourneeComponent},
      {path: 'personnel', component: PersonnelComponent},
      {path: 'detail', component: DetailJourneeComponent},
      {path: 'exercice', component: ExercieComponent},
      {path: 'suivie', component: SuiviComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TemplateRoutingModule { }
