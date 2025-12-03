import { Component, OnInit, signal, ViewChild } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Table, TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormsModule, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { RippleModule } from 'primeng/ripple';
import { ToastModule } from 'primeng/toast';
import { ToolbarModule } from 'primeng/toolbar';
import { RatingModule } from 'primeng/rating';
import { InputTextModule } from 'primeng/inputtext';
import { TextareaModule } from 'primeng/textarea';
import { SelectModule } from 'primeng/select';
import { RadioButtonModule } from 'primeng/radiobutton';
import { InputNumberModule } from 'primeng/inputnumber';
import { DialogModule } from 'primeng/dialog';
import { TagModule } from 'primeng/tag';
import { InputIconModule } from 'primeng/inputicon';
import { IconFieldModule } from 'primeng/iconfield';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { Professor, ProfessorService } from './professor.service';
import { FluidModule } from 'primeng/fluid';


interface Column {
    field: string;
    header: string;
    customExportHeader?: string;
}

interface ExportColumn {
    title: string;
    dataKey: string;
}

@Component({
    selector: 'app-crud',
    standalone: true,
    imports: [
        CommonModule,
        TableModule,
        FormsModule,
        ButtonModule,
        RippleModule,
        ToastModule,
        ToolbarModule,
        RatingModule,
        InputTextModule,
        TextareaModule,
        SelectModule,
        RadioButtonModule,
        InputNumberModule,
        DialogModule,
        TagModule,
        InputIconModule,
        IconFieldModule,
        ConfirmDialogModule,
        FluidModule,
        ReactiveFormsModule,
    ],
    templateUrl: './professor.html',
    providers: [MessageService, ProfessorService, ConfirmationService]
})
export class ProfessorComponent implements OnInit {
   

    professores = signal<Professor[]>([]);

    professor!: Professor;

    professorSelecionado!: Professor | null;

    novoForm: FormGroup;
    novoForm_exibir: boolean = false;
    
    @ViewChild('dt') dt!: Table;

    exportColumns!: ExportColumn[];

    cols!: Column[];

    constructor(
        private cursoService: ProfessorService,
        private messageService: MessageService,
        private confirmationService: ConfirmationService,
        private fb: FormBuilder
    )
    { 
        this.novoForm = this.fb.group({
            nome: ['', Validators.required],
            qtdSemestres: ['', Validators.required]
        });
    }

    exportCSV() {
        this.dt.exportCSV();
    }

    ngOnInit() {
        this.loadDados();
    }

    loadDados() {
        this.cursoService.getProfessores().subscribe({
            next: (data) => {
                this.professores.set(data);
                console.log('Cursos fetched successfully:', this.professores());
            },
            error: (err) => {
                console.error('Error fetching cursos:', err);
            }   
        });

        this.cols = [
            { field: 'nome', header: 'Professor', customExportHeader: 'Nome Professor' },
            { field: 'email', header: 'Email' },
        ];

        this.exportColumns = this.cols.map((col) => ({ title: col.header, dataKey: col.field }));
    }

    onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal((event.target as HTMLInputElement).value, 'contains');
    }

    btnNovo() {
        this.professor = {};
        this.novoForm.reset();
        this.novoForm_exibir = true;
    }
    
    formNovo_onSubmit(){
        if (this.novoForm.valid) {
            
            this.professor = this.novoForm.value;

            this.cursoService.salvar(this.professor).subscribe({
                next: () => {
                    this.messageService.add({severity:'success', summary: 'Sucesso', detail: 'Curso salvo com sucesso'});
                    this.loadDados();
                    
                },
                error: (erro) => {
                    this.messageService.add({severity:'error', summary: 'Erro', detail: 'Erro ao salvar novo curso'});
                    console.error('Erro ao salvar curso:', erro);
                }
            });
        }
        else{
           this.novoForm.markAllAsTouched();
        }
    }
    
    formNovo_btnCancelar(){
        this.novoForm_exibir = false;
    }

    btnEditar() {
    }

    btnDeletar() {
        if(!this.professorSelecionado) {    
            this.messageService.add({
                severity: 'info',
                summary: 'Atenção',
                detail: 'Você precisa selecionar um professor',
                life: 5000
            });

            return;
        }
        this.confirmationService.confirm({
            message: 'Tem cereza que deseja deletar esse professor?',
            header: 'Confirmação',
            icon: 'pi pi-exclamation-triangle',
            acceptLabel: 'Sim',
            rejectLabel: 'Não',
            accept: () => {
                this.cursoService.deletar(this.professorSelecionado?.id!).subscribe({
                    next: () => {
                        this.messageService.add({
                            severity: 'success',
                            summary: 'Deletado',
                            detail: 'Professor deletado com sucesso',
                            life: 5000
                        });
                        this.loadDados();
                    },
                    error: (erro) => {
                        this.messageService.add({
                            severity: 'error',
                            summary: 'Ops...',
                            detail: 'Algo deu errado, tente novamente mais tarde',
                            life: 5000
                        });
                        console.error('Erro ao deletar professor:', erro);}
                });
            }
        });
    }
}
