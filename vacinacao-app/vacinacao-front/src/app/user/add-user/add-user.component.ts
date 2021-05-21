import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user.service';
import { User } from '../user.interface';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  form: FormGroup = this.fb.group({
    name: [null],
    dtNasc: [null],
    gender: [null],
    publicPlace: [null],
    number: [null],
    sector: [null],
    city: [null],
    uf: [null]
  });;

  constructor(private fb: FormBuilder,
    private schedulerService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const user: User = {
      dtNasc: this.form.controls.dtNasc.value,
      gender: this.form.controls.gender.value,
      name: this.form.controls.name.value,
      number: this.form.controls.number.value,
      publicPlace: this.form.controls.publicPlace.value,
      city: this.form.controls.city.value,
      sector: this.form.controls.sector.value,
      uf: this.form.controls.uf.value
    };

    this.schedulerService.saveUser(user).subscribe((success) => {
      this.router.navigateByUrl('#');
    }, error => {
      console.log(error)
    });
  }

  changeGender(e: any) {
    this.form.patchValue({
      gender: e.target.value,
    });
  }

}
