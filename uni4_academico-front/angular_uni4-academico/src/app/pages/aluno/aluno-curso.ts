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
import { AlunoCursoService, Curso } from './aluno-curso.service';
import { ToolbarModule } from 'primeng/toolbar';
import { SplitButtonModule } from 'primeng/splitbutton';

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
    cursosAluno: Curso[] = [];


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
        private alunoCursoService: AlunoCursoService
    ) {}

    ngOnInit() {
        // Semestres
        this.semestreSelectValues = [
            { id: 1, name: '01/2024' },
            { id: 2, name: '02/2024' },
            { id: 3, name: '01/2025' },
            { id: 3, name: '02/2025' },
            { id: 3, name: '01/2026' },
        ];
        this.cursoSelectValues = [
            { id: 1, name: 'Direto' },
            { id: 2, name: 'Informática' },
        ];
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

    getSeverity(status: string) {
        switch (status) {
            case 'qualified':
            case 'instock':
            case 'INSTOCK':
            case 'DELIVERED':
            case 'delivered':
                return 'success';

            case 'negotiation':
            case 'lowstock':
            case 'LOWSTOCK':
            case 'PENDING':
            case 'pending':
                return 'warn';

            case 'unqualified':
            case 'outofstock':
            case 'OUTOFSTOCK':
            case 'CANCELLED':
            case 'cancelled':
                return 'danger';

            default:
                return 'info';
        }
    }

}
