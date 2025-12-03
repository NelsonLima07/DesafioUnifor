import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import { environment } from '../../../environments/environments';


export interface Professor {
    id?: number;
    nome?: string;
    email?: string;
}

@Injectable()
export class ProfessorService {
    
    private urlAPI = `${environment.apiUrl}/professores`;
    
    constructor(private httpClient: HttpClient) {}

    getProfessores():Observable<Professor[]> {
        return this.httpClient.get<Professor[]>(this.urlAPI);
    }

    deletar(id: number): Observable<void> {
        return this.httpClient.delete<void>(`${this.urlAPI}/${id}`);
    }

    salvar(obj: Professor): Observable<Professor> {
        return this.httpClient.post<Professor>(`${this.urlAPI}`, obj);
    }


}
