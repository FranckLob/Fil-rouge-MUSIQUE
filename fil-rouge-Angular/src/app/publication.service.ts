import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Publication} from './publication';


@Injectable({
  providedIn: 'root'
})
export class PublicationService {

  private publications = [{ 
    }
  ];

  items = [];
  publication: Publication;

  constructor() {
    this.items = this.publications;
  }

  // getPublications() {
  //   return this.items;
  // }


  addItem(item: Publication) {
    this.items.push(item);
  }

  setPublication(item: Publication) {
    this.publication = item;
  }

  getPublication() {
    console.log('edit -> ', this.publication.title);
    return this.publication;
  }

}
