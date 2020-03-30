import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Publication} from './publication';
import {Type} from './type';
import { Style } from './style';

@Injectable({
  providedIn: 'root'
})
export class PublicationService {


  constructor(private http:HttpClient) { }


// create publication provided as parameter
//  createPublication(publication:Publication) : Observable<Publication> {
//  return this.http.post <Publication>('http://localhost:8080/api/share_music/publication', publication);
// }

  postPublicationObservable(publication : Publication) : Observable<Publication> {
    const url='http://localhost:8080/api/publications';
    return this.http.post<Publication>(url,publication);
  }

/**
   * Update a Publication for considered user/owner
   */
  putPublicationObservable(publication : Publication) : Observable<Publication> {
    const url='http://localhost:8080/api/publications';
    return this.http.put<Publication>(url,publication);
  }

  getPublications(pageNumber) : Observable<any>{
    return this.http.get <any>('http://localhost:8080/api/publications?pageNumber='+pageNumber);
  }

  getPublicationsSortedByCriteria(criteria, direction):Observable<any> {
    let url = 'http://www.localhost:8080/api/publications/sort?sortCriteria=' + criteria + '&sortDirection=' + direction ;
    return this.http.get<any>(url);
  }

  deletePublication(publicationId: number) : Observable<Publication> {
    console.log(publicationId);
    return this.http.delete<Publication>('http://localhost:8080/api/publications/' + publicationId);
  }

  getTypes() : Observable<Type[]> {
    return this.http.get<Type[]>('http://localhost:8080/api/type');
  }

  getStyles() : Observable<Style[]> {
    return this.http.get<Style[]>('http://localhost:8080/api/style');
  }

  getOnePublication(publicationId: number) : Observable<Publication> {
    return this.http.get<Publication>('http://localhost:8080/api/publications/' + publicationId);
  }

}
