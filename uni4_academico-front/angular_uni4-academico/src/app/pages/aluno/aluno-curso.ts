import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { InputTextModule } from 'primeng/inputtext';
import { MultiSelectModule } from 'primeng/multiselect';
import { SelectModule } from 'primeng/select';
import { SliderModule } from 'primeng/slider';
import { Table, TableModule } from 'primeng/table';
import { ProgressBarModule } from 'primeng/progressbar';
import { ToggleButtonModule } from 'primeng/togglebutton';
import { ToastModule } from 'primeng/toast';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { RatingModule } from 'primeng/rating';
import { RippleModule } from 'primeng/ripple';
import { InputIconModule } from 'primeng/inputicon';
import { IconFieldModule } from 'primeng/iconfield';
import { TagModule } from 'primeng/tag';
import {ObjectUtils} from "primeng/utils";
import { AlunoCursoService, Curso, IHistorico } from './aluno-curso.service';
import { ToolbarModule } from 'primeng/toolbar';
import { SplitButtonModule } from 'primeng/splitbutton';
import { SemestreService } from '../../core/services/semestre.service';
import { AuthService } from '../../core/services/auth.service';             

interface expandedRows {
    [key: string]: boolean;
}

@Component({
    selector: 'app-table-demo',
    standalone: true,
    imports: [
        TableModule,
        MultiSelectModule,
        SelectModule,
        InputIconModule,
        TagModule,
        InputTextModule,
        SliderModule,
        ProgressBarModule,
        ToggleButtonModule,
        ToastModule,
        CommonModule,
        FormsModule,
        ButtonModule,
        RatingModule,
        RippleModule,
        IconFieldModule,
        ToolbarModule,
        SplitButtonModule
    ],
    templateUrl:'./aluno-curso.html',
    styles: `
        .p-datatable-frozen-tbody {
            font-weight: bold;
        }

        .p-datatable-scrollable .p-frozen-column {
            font-weight: bold;
        }
    `,
    providers: [ConfirmationService, MessageService, AlunoCursoService]
})

export class AlunoCursoComponent implements OnInit {
    historicoAluno: IHistorico[] = [];


    semestreSelectValues : any[] = [];
    semestreSelectValue: any;
    
    cursoSelectValues : any[] = []; 
    cursoSelectValue  : any;
    

    statuses: any[] = [];

    rowGroupMetadata: any;

    expandedRows: expandedRows = {};

    activityValues: number[] = [0, 100];

    isExpanded: boolean = false;

    balanceFrozen: boolean = false;

    loading: boolean = true;

    @ViewChild('filter') filter!: ElementRef;

    constructor(
        private alunoCursoService: AlunoCursoService,
        private semestreService: SemestreService,
        private authService: AuthService
    ) {}

    ngOnInit() {
        
        const idAluno = this.authService.getUserID();

        // Semestres
        this.semestreService.getSemestres().subscribe((data) => {
            this.semestreSelectValues = data.map(semestre => ({
                id: semestre.id,
                name: `${semestre.numSemestre}/${semestre.ano}`
            }));
        });
        
        // Cursos do aluno
        this.alunoCursoService.getCursosAluno(idAluno).subscribe((data) => {
            this.cursoSelectValues = data.map(curso => ({
                id: curso.id,
                name: curso.nome
            }));
        });

        // historico do aluno
        this.alunoCursoService.getHistoricoAluno(idAluno).subscribe((data) => {
          this.historicoAluno = data;
          this.loading = false;
          console.log(data);
        });
 
        
    }

    onSort() {
        //this.updateRowGroupMetaData();
    }

    onGlobalFilter(table: Table, event: Event) {
        table.filterGlobal((event.target as HTMLInputElement).value, 'contains');
    }

    clear(table: Table) {
        table.clear();
        this.filter.nativeElement.value = '';
    }

    getStatus(status: number) {
        switch (status) {
            case 1:
                return 'Cursando';

            case 2:
                return 'Aprovado';
            
            case 3:
                return 'Reprovado'
            
            default:
                return 'Error';
        }
    }

    getStatusSeverity(status: number) {
        switch (status) {
            case 1:
                return 'info';

            case 2:
                return 'success';
            
            case 3:
                return 'danger'
            
            default:
                return 'secondary';
        }
    }

}
