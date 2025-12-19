import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, of, throwError } from 'rxjs';
import { environment } from '../../../environments/environments';
import { Router } from '@angular/router';


export interface UsuarioRequestInfo {
    role?: string;
    keycloakId?: string;
}


@Injectable({ providedIn: 'root' })
export class AuthService {
  
  private urlAPI_login = `${environment.apiUrl}/auth/login`;
  private urlAPI_getUserID = `${environment.apiUrl}/auth/getUserID`;


  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string) {
    if (!username || !password) {
      console.log("Email e senha são obrigatórios!");
      return;
    } 
    else {    
      this.http.post<{ access_token: string }>(this.urlAPI_login, { username, password }).subscribe({
        next: (response) => {
          console.log('Login bem-sucedido');    
          localStorage.setItem('uni4-academico_token', response.access_token);

          this.getInfoUser();
          
        },
        error: (err) => {

          if (err.status === 401) {
            alert('Email ou Senha inválidos.');
            console.error('Erro não autorizado:', err);
          }else {
            alert('Ocorreu um erro ao conectar com o servidor. Tente novamente mais tarde.');
            console.error('Erro ao conectar ao servidor. Por favor, tente novamente mais tarde.');
          }
        },
      }); 
    }
  }


  logout() {
    localStorage.removeItem('uni4-academico_token');
    localStorage.removeItem('uni4-academico_userinfo');
    this.router.navigate(['/login']);
  }

  getInfoUser() {
    
    const usuarioRequestInfo: UsuarioRequestInfo = {
      role: this.getUserRoles()[0],
      keycloakId: this.getUserUUID()!
    };
    
    
    console.log(usuarioRequestInfo);
    // Carrega os dados do BD no Sistema. ID da Tabela;
    this.http.post<number>(this.urlAPI_getUserID, usuarioRequestInfo).subscribe({
      next: (response: number) => {
        console.log(response);
        localStorage.setItem('uni4-academico_userinfo', response.toString());
        this.router.navigate(['/']); // redireciona para home
      },
      error: (err) => {
        this.logout();
        console.error('Erro ao conectar ao servidor. Por favor, tente novamente mais tarde.' + err.message);
      }
    }); 
    
  }

  getUserRoles(): string[] {
  const token = localStorage.getItem('uni4-academico_token');
  if (!token) return [];

  try {
    const parts = token.split('.');
    if (parts.length !== 3) return [];
    

    let payloadBase64 = parts[1];
    payloadBase64 = payloadBase64.replace(/-/g, '+').replace(/_/g, '/');
   
    while (payloadBase64.length % 4) {
      payloadBase64 += '=';
    }
    
    const payloadDecoded = atob(payloadBase64);
    const payload = JSON.parse(payloadDecoded);
    
    return payload?.realm_access?.roles || [];
  } catch (e) {
    console.error('Erro ao decodificar token:', e);
    return [];
  }
}

getUserName(): string | null {
  const token = localStorage.getItem('uni4-academico_token');
  if (!token) return null;    
  try {
    const parts = token.split('.');
    if (parts.length !== 3) return null;    
    let payloadBase64 = parts[1];
    payloadBase64 = payloadBase64.replace(/-/g, '+').replace(/_/g, '/');  
    while (payloadBase64.length % 4) {
      payloadBase64 += '=';
    }
    const payloadDecoded = atob(payloadBase64);
    const payload = JSON.parse(payloadDecoded);    
    console .log('Token:', payload);
    return payload?.preferred_username || null;
  } catch (e) {
    console.error('Erro ao decodificar token:', e);
    return null;
  }     
}

getUserUUID(): string | null {
  const token = localStorage.getItem('uni4-academico_token');
  if (!token) return null;    
  try { 
    const parts = token.split('.');   
    if (parts.length !== 3) return null;
    let payloadBase64 = parts[1];
    payloadBase64 = payloadBase64.replace(/-/g, '+').replace(/_/g, '/');
    while (payloadBase64.length % 4) {
      payloadBase64 += '=';
    }   
    const payloadDecoded = atob(payloadBase64);
    const payload = JSON.parse(payloadDecoded);    
 
    return payload?.sub || null;
  } catch (e) {
    console.error('Erro ao decodificar token:', e);
    return null;
  }   
}

getUserID(){
  const userID = localStorage.getItem('uni4-academico_userinfo');
  return userID ? Number(userID) : null;  
}

}


