import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Publication} from './publication';

@Injectable({
  providedIn: 'root'
})
export class PublicationService {


  constructor(private http:HttpClient) { }


// create publication provided as parameter
createPublication(publication:Publication) : Observable<Publication> {
  return this.http.post <Publication>('http://localhost:8080/api/share_music/publication', publication);
 }




  getPublications() : Observable<any>{
    return this.http.get <any>('http://localhost:8080/api/publications');
  }



  // addItem(item: Publication) {
  //   this.items.push(item);
  // }

  // setPublication(item: Publication) {
  //   this.publication = item;
  // }

  // getPublication() {
  //   console.log('edit -> ', this.publication.title);
  //   return this.publication;
  // }

}
