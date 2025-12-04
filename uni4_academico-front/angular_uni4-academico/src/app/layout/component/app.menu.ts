import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { AppMenuitem } from './app.menuitem';

@Component({
    selector: 'app-menu',
    standalone: true,
    imports: [CommonModule, AppMenuitem, RouterModule],
    template: `<ul class="layout-menu">
        <ng-container *ngFor="let item of model; let i = index">
            <li app-menuitem *ngIf="!item.separator" [item]="item" [index]="i" [root]="true"></li>
            <li *ngIf="item.separator" class="menu-separator"></li>
        </ng-container>
    </ul> `
})
export class AppMenu {
    model: MenuItem[] = [];

    ngOnInit() {
        this.model = [
            {
                label: 'Home',
                items: [{ label: 'Home', icon: 'pi pi-fw pi-home', routerLink: ['/home'] }]
            },
            {
                label: 'Aluno',
                items: [
                    { label: 'Meus Cursos', icon: 'pi pi-graduation-cap', routerLink: ['/aluno/cursos'] }
                ]
            },
            {
                label: 'Professor',
                icon: 'pi pi-fw pi-briefcase',
                items: [
                    {
                        label: 'Lançar Notas',
                        icon: 'pi pi-book',
                        routerLink: ['/professor/disciplinas']
                    },
                ]
            },
            {
                label: 'Coordenador',
                items: [
                    {
                        label: 'Professores',
                        icon: 'pi pi-briefcase',
                        routerLink: ['/coordenador/professores'],
                    },
                    {
                        label: 'Cursos',
                        icon: 'pi pi-graduation-cap',
                        routerLink: ['/coordenador/cursos'],
                    },
                    {
                        label: 'Alunos',
                        icon: 'pi pi-users',
                        routerLink: ['/coordenador/alunos'],
                    },
                ]
            },
            {
                label: 'Utils',
                items: [
                    {
                        label: 'Suporte',
                        icon: 'pi pi-wrench',
                        routerLink: ['/suporte']
                    },
                    {
                        label: 'Links',
                        icon: 'pi pi-globe',
                        routerLink: ['/links'],
                    }
                ]
            }
        ];
    }
}
