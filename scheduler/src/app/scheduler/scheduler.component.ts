import { Scheduler } from './scheduler.interface';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SchedulerService } from './scheduler.service';
@Component({
  selector: 'app-scheduler',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css'],
})
export class SchedulerComponent implements OnInit {
  schedulers: Scheduler[] = [];
  schedulerOriginalState: Scheduler[] = [];

  constructor(
    private route: Router,
    private schedulerService: SchedulerService
  ) {}

  ngOnInit(): void {
    this.getAllScheduler();
  }

  add() {
    this.route.navigateByUrl('/scheduler-add');
  }

  getAllScheduler() {
    this.schedulerService.getAllScheduler().subscribe((schedulers) => {
      this.schedulers = schedulers.sort(this.sortParameter);
      this.schedulerOriginalState = schedulers;
    });
  }

  vacinar(scheduler: Scheduler) {
    const newScheduler: Scheduler = {
      code: scheduler.code,
      cpf: scheduler.cpf,
      date: new Date(scheduler.date),
      dischargeDate: new Date(),
      dose: scheduler.dose,
      local: scheduler.local,
      patient: scheduler.patient,
      period: scheduler.period,
      situation: 2,
    };

    this.schedulerService.vaccinate(newScheduler).subscribe((success) => {
      this.getAllScheduler();
    });
  }

  cancelar(scheduler: Scheduler) {
    const newScheduler: Scheduler = {
      code: scheduler.code,
      cpf: scheduler.cpf,
      date: new Date(scheduler.date),
      dischargeDate: new Date(),
      dose: scheduler.dose,
      local: scheduler.local,
      patient: scheduler.patient,
      period: scheduler.period,
      situation: 3,
    };

    this.schedulerService.cancel(newScheduler).subscribe((success) => {
      this.getAllScheduler();
    });
  }

  sortParameter(a, b) {
    if (a.situation > b.situation) {
      return 0;
    }
    if (b.situation < a.situation) {
      return 1;
    }
    return -1;
  }

  sortBy(option: number) {
    if (option == 1) {
      this.viewCancelledOnly();
    } else if (option == 2) {
      this.viewFulfilledAndExecutedsOnly();
    } else {
      this.getAllScheduler();
    }
  }

  viewCancelledOnly() {
    const cancelleds = this.schedulerOriginalState;
    this.schedulers = cancelleds.filter((schedule) => schedule.situation == 3);
  }

  viewFulfilledAndExecutedsOnly() {
    const cancelleds = this.schedulerOriginalState;
    this.schedulers = cancelleds.filter(
      (schedule) => schedule.situation == 1 || schedule.situation == 2
    );
  }
}
