import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class Guard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(): boolean {
    const token = localStorage.getItem('uni4-academico_token');
    if (!token) {
      this.router.navigate(['/login']);
      return false;
    }
    return true;
  }
}
