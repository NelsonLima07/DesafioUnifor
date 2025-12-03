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
import { Curso, CursoService } from './curso.service';
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
    templateUrl: './curso.html',
    providers: [MessageService, CursoService, ConfirmationService]
})
export class CursoComponent implements OnInit {
   

    cursos = signal<Curso[]>([]);

    curso!: Curso;

    selecionadosCursos!: Curso[] | null;
    cursoSelecionado!: Curso | null;

    novoForm: FormGroup;
    novoForm_exibir: boolean = false;
    
    @ViewChild('dt') dt!: Table;

    exportColumns!: ExportColumn[];

    cols!: Column[];

    constructor(
        private cursoService: CursoService,
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
        this.cursoService.getCursos().subscribe({
            next: (data) => {
                this.cursos.set(data);
                console.log('Cursos fetched successfully:', this.cursos());
            },
            error: (err) => {
                console.error('Error fetching cursos:', err);
            }   
        });

        this.cols = [
            { field: 'nome', header: 'Curso', customExportHeader: 'Nome Curso' },
            { field: 'qtdSemestres', header: 'Semestres' },
        ];

        this.exportColumns = this.cols.map((col) => ({ title: col.header, dataKey: col.field }));
    }

    onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal((event.target as HTMLInputElement).value, 'contains');
    }

    btnNovo() {
        this.curso = {};
        this.novoForm.reset();
        //this.submitted = false;
        this.novoForm_exibir = true;
    }
    
    formNovo_onSubmit(){
        if (this.novoForm.valid) {
            
            this.curso = this.novoForm.value;

            this.cursoService.salvar(this.curso).subscribe({
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
        //this.curso = { ...curso };
        //this.productDialog = true;
    }

    btnDeletar() {
        if(!this.cursoSelecionado) {    
            this.messageService.add({
                severity: 'info',
                summary: 'Atenção',
                detail: 'Você precisa selecionar um Curso',
                life: 5000
            });

            return;
        }
        this.confirmationService.confirm({
            message: 'Tem cereza que deseja deletar esse curso?',
            header: 'Confirmação',
            icon: 'pi pi-exclamation-triangle',
            acceptLabel: 'Sim',
            rejectLabel: 'Não',
            accept: () => {
                this.cursoService.deletar(this.cursoSelecionado?.id!).subscribe({
                    next: () => {
                        this.messageService.add({
                            severity: 'success',
                            summary: 'Deletado',
                            detail: 'Curso deletado com sucesso',
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
                        console.error('Erro ao deletar curso:', erro);}
                });
            }
        });
    }
}
