import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import { environment } from '../../../environments/environments';


export interface Curso {
    id?: number;
    nome?: string;
    qtdsemestres?: number;
}

@Injectable()
export class CursoService {
    
    private urlAPI = `${environment.apiUrl}/cursos`;
    
    constructor(private httpClient: HttpClient) {}

    getCursos():Observable<Curso[]> {
        return this.httpClient.get<Curso[]>(this.urlAPI);
    }

    deletar(id: number): Observable<void> {
        return this.httpClient.delete<void>(`${this.urlAPI}/${id}`);
    }

    salvar(curso: Curso): Observable<Curso> {
        return this.httpClient.post<Curso>(`${this.urlAPI}`, curso);
    }


}
