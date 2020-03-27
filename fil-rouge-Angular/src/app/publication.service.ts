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


  deletePublication(publicationId: number) : Observable<Publication> {
    console.log(publicationId);
    return this.http.delete<Publication>('http://localhost:8080/api/publications/' + publicationId);
 }


//  sortByAppUser(a, b) {
//   console.log("Dans sortByAppUser du service");
//   return (a.appUser.nickName > b.appUser.nickName) ? 1 : ((b.appUser.nickName > a.appUser.nickName) ? -1 : 0);
// }

// sortByArtist(a, b) {
//   console.log("Dans sortByArtist du service");
//   return (a.artist.name > b.artist.name) ? 1 : ((b.artist.name > a.artist.name) ? -1 : 0);
// }

// sortByDate(a, b) {
//   console.log("Dans sortByDate du service");
//   return (a.date > b.date) ? 1 : ((b.date > a.date) ? -1 : 0);
// }

// sortByArtwork(a, b) {
//   console.log("Dans sortByArtwork du service");
//   return (a.artwork.name > b.artwork.name) ? 1 : ((b.artwork.name > a.artwork.name) ? -1 : 0);
// }

// sortByTitle(a, b) {
//   console.log("Dans sortByTitle du service");
//   return (a.title.name > b.title.name) ? 1 : ((b.title.name > a.title.name) ? -1 : 0);
// }

// sortByStyle(a, b) {
//   console.log("Dans sortByStyle du service");
//   return (a.style.name > b.style.name) ? 1 : ((b.style.name > a.style.name) ? -1 : 0);
// }

// sortByType(a, b) {
//   console.log("Dans sortByType du service");
//   return (a.type.name > b.type.name) ? 1 : ((b.type.name > a.type.name) ? -1 : 0);
// }

// sortByAuthor(a, b) {
//   console.log("Dans sortByAuthor du service");
//   return (a.author.name > b.author.name) ? 1 : ((b.author.name > a.author.name) ? -1 : 0);
// }

// sortByComposer(a, b) {
//   console.log("Dans sortByComposer du service");
//   return (a.composer.name > b.composer.name) ? 1 : ((b.composer.name > a.composer.name) ? -1 : 0);
// }

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
