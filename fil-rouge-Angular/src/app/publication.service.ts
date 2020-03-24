import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Publication} from './publication';


@Injectable({
  providedIn: 'root'
})
export class PublicationService {

  private publications = [{
    id:1,
    appUser:'Yben',
    artist:'Carlos',
    date : '2020-03-24',
    artwork:'Les grands noms de la chanson à texte',
    title:'Big Bisou',
    style:'daube',
    type:'musique contemporaine',
    author:'Didier Barbelivien',
    composer:'Wagner',
    snippet:'https://www.youtube.com/watch?v=wcQXW5mje70',
    },

    {
    id:2,
    appUser:'Yben',
    artist:'Carla Bruni',
    date : '2020-03-24',
    artwork:'Femme de président',
    title:'Y a qqun ki m a dit',
    style:'folk',
    type:'musique contemporaine',
    author:'Carla Bruni',
    composer:'Carla Bruni',
    snippet:'https://www.youtube.com/watch?v=EC7Re8cczj0',
    },
    {
    id:3,
    appUser:'Yben',
    artist:'Guillaume Farley',
    date : '2020-03-24',
    artwork:'funny covers',
    title:'What do you want',
    style:'pop',
    type:'musique contemporaine',
    author:'Jacques Chirac',
    composer:'Guillaume Farley',
    snippet:'https://www.youtube.com/watch?v=KTHTj5glhCI',
    
    }
  ];

  items = [];
  publication: Publication;

  constructor() {
    this.items = this.publications;
  }

  getPublications() {
    return this.items;
  }


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
