import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, of, throwError } from 'rxjs';
import { environment } from '../../../environments/environments';
import { Router } from '@angular/router';


@Injectable({ providedIn: 'root' })
export class AuthService {
  
  private urlAPI = `${environment.apiUrl}/auth/login`;

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string) {
    if (!username || !password) {
      console.log("Email e senha são obrigatórios!");
      return;
    } 
    else {    
     
      this.http.post<{ access_token: string }>(this.urlAPI, { username, password }).subscribe({
        next: (response) => {
          console.log('Login bem-sucedido');    
          localStorage.setItem('uni4-academico_token', response.access_token);
          this.router.navigate(['/']); // redireciona para home

        },
        error: (err) => {
          console.error('Erro no login:', err);
        },
      }); 
      }
    
  }


  logout() {
    localStorage.removeItem('uni4-academico_token');
  }
}