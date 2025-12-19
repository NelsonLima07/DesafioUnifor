import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { CheckboxModule } from 'primeng/checkbox';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { RippleModule } from 'primeng/ripple';
import { AppFloatingConfigurator } from '../../layout/component/app.floatingconfigurator';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environments';
import { LoginRequest } from './login-request.model';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../core/services/auth.service';
import { LayoutService } from '../../layout/service/layout.service';



@Component({
    selector: 'app-login',
    standalone: true,
    imports: [ButtonModule, CheckboxModule, InputTextModule, PasswordModule, FormsModule, RouterModule, RippleModule, /* AppFloatingConfigurator,*/ ReactiveFormsModule],
    templateUrl: './login.html'
})
export class Login {
    private urlAPI = `${environment.apiUrl}/cursos`;
    
    loginForm: FormGroup;
    //username: string = '';
    //password: string = '';
    checked: boolean = false;
    
    constructor(
        private fb: FormBuilder,
        private router: Router,
        private httpClient: HttpClient,
        private authService: AuthService,
        private layoutService: LayoutService
    )
    {
        this.loginForm = this.fb.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
        this.layoutService.toggleDarkMode(this.layoutService.layoutConfig());
    }

    ngOnInit(): void {
        this.authService.logout();
    }

    onSubmit() {
        if (this.loginForm.valid) {

            this.authService.login(this.loginForm.get('username')!.value, this.loginForm.get('password')!.value);

        }
        else{
            alert('Por favor, preencha todos os campos Email e Senha.');
            console.error('Login falhou. Formulário Inválido.');
            this.loginForm.markAllAsTouched();
        }
    } 
}
