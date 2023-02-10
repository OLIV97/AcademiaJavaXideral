import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { from, Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Personal } from '../interfaces/personal';


@Injectable({
  providedIn: 'root'
})
export class PersonalService {

  constructor(private http: HttpClient) { }

  public all_personal(): Observable<Personal[]> {

    return this.http.get<Personal[]>(environment.url_api_personal + "/api/personal");
  }

  public personal(id:number): Observable<Personal> {

    return this.http.get<Personal>(environment.url_api_personal +`/api/personal/${id}`);
  }

  public save_personal(nombres: string, apelidos: string): Observable<Personal> {

    return this.http.post<Personal>(environment.url_api_personal + "/api/personal", {
      "nombres": nombres,
      "apellidos": apelidos,
      "horaentrada": null,
      "horasalida": null
    });

  }

  public update_personal(person:Personal): Observable<Personal> {

    return this.http.put<Personal>(environment.url_api_personal + "/api/personal", {
      "id": person.id,
      "nombres": person.nombres,
      "apellidos": person.apellidos,
      "horaentrada": person.horaentrada,
      "horasalida": person.horasalida
    });

  }

  public check_personal(id:number,type:string): Observable<Personal> {

    return this.http.put<Personal>(environment.url_api_personal +`/api/personal/check/${id}/${type}`,{});
  }
  public personal_delete(id:number): Observable<String> {

    return this.http.delete<String>(environment.url_api_personal +`/api/personal/${id}`);
  }

}
