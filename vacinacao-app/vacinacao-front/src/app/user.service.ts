import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user/user.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  API_URL = 'http://localhost:8080/user';
  constructor(private http: HttpClient) { }

  saveUser(user: User) {
    return this.http.post(this.API_URL, user);
  }

  getAllUser(): Observable<User[]> {
    return this.http.get<User[]>(this.API_URL);
  }

  removerUser(id: number) {
    return this.http.delete<User>(this.API_URL + '/' + id);
  }

  updateUser(newUser: User) {
    return this.http.put<User>(this.API_URL, newUser);
  }

}
