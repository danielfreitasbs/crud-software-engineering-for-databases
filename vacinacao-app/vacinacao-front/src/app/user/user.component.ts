import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from './user.interface';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  form = this.formBuilder.group({
    searchParameter: [null]
  })

  users: User[] = [];

  constructor(
    private route: Router,
    private userService: UserService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.getAllUser();
  }

  add() {
    this.route.navigateByUrl('/add-user');
  }

  getAllUser() {
    this.userService.getAllUser().subscribe((users) => {
      this.users = users;
    });
  }

  remover(user: User) {
    console.log(user);
    if (user.id) {
      this.userService.removeUser(user.id).subscribe(success => {
        this.getAllUser();
      });
    }
  }

  findById() {
    const id = this.form.controls.searchParameter.value;

    if (id) {
      this.userService.findById(id).subscribe((user: User) => {
        const tempUsers = [user];
        this.users = tempUsers;
      }, (error) => {
        this.users = [];
      })
    } else {
      this.getAllUser();
    }

  }

}
