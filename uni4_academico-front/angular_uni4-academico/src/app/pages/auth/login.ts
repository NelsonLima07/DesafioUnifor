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

@Component({
    selector: 'app-login',
    standalone: true,
    imports: [ButtonModule, CheckboxModule, InputTextModule, PasswordModule, FormsModule, RouterModule, RippleModule, /* AppFloatingConfigurator,*/ ReactiveFormsModule],
    templateUrl: './login.html'
})
export class Login {
    loginForm: FormGroup;
    email: string = '';
    password: string = '';
    checked: boolean = false;
    
    constructor(
        private fb: FormBuilder,
        private router: Router
    )
    {
        this.loginForm = this.fb.group({
            email: ['', Validators.required],
            password: ['', Validators.required]
        });
    }

    onSubmit() {
        if (this.loginForm.valid) {
            
            console.log('Formulário Válido. Tentando logar...');
            
            const token = 'fake-jwt-token';
            localStorage.setItem('uni4-academico_token', token);
            this.router.navigate(['/']);
        }
        else{
            console.error('Login falhou. Formulário Inválido.');
            this.loginForm.markAllAsTouched();
        }
    } 

}
