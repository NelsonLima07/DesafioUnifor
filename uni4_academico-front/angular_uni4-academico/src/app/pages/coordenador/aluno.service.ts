import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import { environment } from '../../../environments/environments';


export interface Aluno {
    id?: number;
    nome?: string;
    email?: string;
}

@Injectable()
export class AlunoService {
    
    private urlAPI = `${environment.apiUrl}/alunos`;
    
    constructor(private httpClient: HttpClient) {}

    getAlunos():Observable<Aluno[]> {
        return this.httpClient.get<Aluno[]>(this.urlAPI);
    }

    deletar(id: number): Observable<void> {
        return this.httpClient.delete<void>(`${this.urlAPI}/${id}`);
    }

    salvar(aluno: Aluno): Observable<Aluno> {
        return this.httpClient.post<Aluno>(`${this.urlAPI}`, aluno);
    }


}
