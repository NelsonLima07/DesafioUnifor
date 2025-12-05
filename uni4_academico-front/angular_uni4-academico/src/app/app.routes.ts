import { Routes } from '@angular/router';
import { AppLayout } from './layout/component/app.layout';
import { Login } from './pages/auth/login';
import { Notfound } from './pages/notfound/notfound';
import { Guard } from './pages/auth/guard';
import { Home } from './pages/home/home';
import { CursoComponent } from './pages/coordenador/curso';
import { AlunoComponent } from './pages/coordenador/aluno';
import { ProfessorComponent } from './pages/coordenador/professor';
import { AlunoCursoComponent } from './pages/aluno/aluno-curso';
import { LinksComponent } from './pages/utils/links';
import { SuporteComponent } from './pages/utils/suporte';



export const appRoutes: Routes = [
  {
      path: 'login', component: Login
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
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
            { path: 'cursos', component: AlunoCursoComponent },
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
         { path: 'links', component: LinksComponent },
         { path: 'suporte', component: SuporteComponent }
    ]
  },
  { path: 'notfound', component: Notfound },
  { path: '**', redirectTo: '/notfound' }
];
 
