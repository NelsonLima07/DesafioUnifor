import { Injectable } from '@angular/core';
import { delay, of, throwError } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  login(email: string, password: string) {
    if (!email || !password) {
      return throwError(() => new Error('Credenciais inválidas')).pipe(delay(500));
    }
    // mock de sucesso
    return of({ token: 'fake-jwt', user: { email } }).pipe(delay(800));
  }

  recover(email: string) {
    if (!email) {
      return throwError(() => new Error('Informe o email')).pipe(delay(500));
    }
    // mock de envio de email
    return of({ message: 'Email de recuperação enviado' }).pipe(delay(800));
  }
}