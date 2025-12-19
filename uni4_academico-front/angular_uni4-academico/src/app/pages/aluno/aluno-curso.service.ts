import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import { environment } from '../../../environments/environments';
import { Curso } from '../coordenador/curso.service';

export type  { Curso };


export interface IHistorico {
    idSemestreAluno: number; 
    numSemestre: number;
    ano: number;
    curso: string;
    disciplina: string;
    nomeProfessor: string;
    codStatus: number; 
    nota: number;
    faltas: number;
}


@Injectable()
export class AlunoCursoService {
    
    private urlAPI = `${environment.apiUrl}/aluno-curso/`;
    
    private urlAPI_semestre = `${environment.apiUrl}/semestre-alunos/`;
    
    constructor(
        private httpClient: HttpClient,
    ) {
    }

    getCursosAluno(idAluno: number | null):Observable<Curso[]> {
        return this.httpClient.get<Curso[]>(`${this.urlAPI}/${idAluno}/cursos`);
    }

    getHistoricoAluno(idAluno: number | null):Observable<IHistorico[]> {
        return this.httpClient.get<IHistorico[]>(`${this.urlAPI_semestre}/${idAluno}/historico`);
    }


}
