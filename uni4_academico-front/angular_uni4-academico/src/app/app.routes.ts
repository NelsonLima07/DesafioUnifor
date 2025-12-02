import { Routes } from '@angular/router';
import { Notfound } from './pages/notfound/notfound';


export const appRoutes: Routes = [
  { path: '', component: Notfound },
  { path: 'notfound', component: Notfound },
  { path: '**', redirectTo: '/notfound' }
];
 
