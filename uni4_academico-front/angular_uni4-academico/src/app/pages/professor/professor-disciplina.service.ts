import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import { environment } from '../../../environments/environments';
import { Curso } from '../coordenador/curso.service';

export type  { Curso };


@Injectable()
export class AlunoCursoService {
    
    private urlAPI = `${environment.apiUrl}/alunos`;
    
    constructor(private httpClient: HttpClient) {}

    getCursosAluno():Observable<Curso[]> {
        return this.httpClient.get<Curso[]>(this.urlAPI);
    }

}
