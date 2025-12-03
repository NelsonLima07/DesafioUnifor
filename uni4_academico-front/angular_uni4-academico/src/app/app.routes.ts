import { Routes } from '@angular/router';
import { AppLayout } from './layout/component/app.layout';
import { Login } from './pages/auth/login';
import { Notfound } from './pages/notfound/notfound';
import { Guard } from './pages/auth/guard';
import { Home } from './pages/home/home';
import { CursoComponent } from './pages/coordenador/curso';
import { AlunoComponent } from './pages/coordenador/aluno';
import { ProfessorComponent } from './pages/coordenador/professor';



export const appRoutes: Routes = [
  {
      path: 'login', component: Login
  },
  {
    path: '',
    component: AppLayout,
    canActivate: [Guard],
    children: [
        { path: 'home', component: Home },
        { 
          path: 'aluno',
          children: [
            { path: '', component: Home },
            { path: 'notas', component: Home },
          ]
        },
        { path: 'professor',
          children: [
            { path: '', component: Home },
            { path: 'diciplinas', component: Home },
          ]
        },
        { path: 'coordenador',
          children: [
            { path: 'professores', component: ProfessorComponent },
            { path: 'cursos', component: CursoComponent },
            { path: 'alunos', component: AlunoComponent },
          ]
         },
    ]
  },
  { path: 'notfound', component: Notfound },
  { path: '**', redirectTo: '/notfound' }
];
 
