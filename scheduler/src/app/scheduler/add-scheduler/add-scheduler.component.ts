import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SchedulerService } from '../scheduler.service';
import { Scheduler } from './../scheduler.interface';

@Component({
  selector: 'app-add-scheduler',
  templateUrl: './add-scheduler.component.html',
  styleUrls: ['./add-scheduler.component.css'],
})
export class AddSchedulerComponent implements OnInit {
  form: FormGroup;
  periodos: [
    { id: 'M'; value: 'Matutino' },
    { id: 'V'; value: 'Vespertino' },
    { id: 'N'; value: 'Noturno' }
  ];
  constructor(
    private fb: FormBuilder,
    private schedulerService: SchedulerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      period: [null],
      patient: [null],
      cpf: [null],
      date: [null],
      dose: [null],
      local: [null],
      situation: [null],
      dischargeDate: [null],
    });
  }

  onSubmit(): void {
    const scheduler: Scheduler = {
      cpf: this.form.get('cpf').value,
      date: new Date(this.form.get('date').value),
      dose: parseInt(this.form.get('dose').value),
      local: this.form.get('local').value,
      patient: this.form.get('patient').value,
      period: this.form.get('period').value,
      situation: parseInt(this.form.get('situation').value),
    };

    this.schedulerService.saveScheduler(scheduler).subscribe((success) => {
      this.router.navigateByUrl('#');
    }, error => {
      console.log(error)
    });
  }

  changePeriod(e) {
    this.form.patchValue({
      period: e.target.value,
    });
  }

  changeDose(e) {
    this.form.patchValue({
      dose: e.target.value,
    });
  }

  changeSituation(e) {
    this.form.patchValue({
      situation: e.target.value,
    });
  }
}
