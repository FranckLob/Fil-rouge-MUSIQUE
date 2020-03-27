import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Publication} from './publication';

@Injectable({
  providedIn: 'root'
})
export class PublicationService {

  publicationpublication
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
    const url='http://localhost:8080/api/publications/'+ publication.id;
    return this.http.put<Publication>(url,publication);
  }

  getPublications() : Observable<any>{
    return this.http.get <any>('http://localhost:8080/api/publications');
  }

  getPublicationsSortedByCriteria(criteria, direction):Observable<any> {
    let url = 'http://www.localhost:8080/api/publications/sort?sortCriteria=' + criteria + '&sortDirection=' + direction ;
    return this.http.get<any>(url);
  }

}
