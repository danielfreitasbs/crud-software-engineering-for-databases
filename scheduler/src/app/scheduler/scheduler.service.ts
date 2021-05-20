import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, ObservedValueOf } from 'rxjs';
import { Scheduler } from './scheduler.interface';

@Injectable({
  providedIn: 'root',
})
export class SchedulerService {
  API_URL = 'http://localhost:8080/scheduler';
  constructor(private http: HttpClient) {}

  saveScheduler(scheduler: Scheduler) {
    return this.http.post(this.API_URL, scheduler);
  }

  getAllScheduler(): Observable<Scheduler[]> {
    return this.http.get<Scheduler[]>(this.API_URL);
  }

  vaccinate(newScheduler: Scheduler) {
    return this.http.put(this.API_URL, newScheduler);
  }

  cancel(newScheduler: Scheduler) {
    return this.http.put(this.API_URL, newScheduler);
  }
}
