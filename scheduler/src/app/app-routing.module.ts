import { AddSchedulerComponent } from './scheduler/add-scheduler/add-scheduler.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: SchedulerComponent },
  { path: 'scheduler-add', component: AddSchedulerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
