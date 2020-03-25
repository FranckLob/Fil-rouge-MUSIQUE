import { Component, OnInit } from '@angular/core';
import { PublicationService } from '../publication.service';
import { User } from '../user';


@Component({
  selector: 'app-publications-list',
  templateUrl: './publications-list.component.html',
  styleUrls: ['./publications-list.component.css']
})
export class PublicationsListComponent implements OnInit {

  publications;
  userLogin:User;

  constructor(
    private publicationService: PublicationService
    ) { }

  ngOnInit() {
 //   this.publications = this.publicationService.getPublications();
    // Read user's Login if exists
    let key = 'login';
     this.userLogin = JSON.parse(localStorage.getItem(key));
  }

  getPublicationForUser(user:User){
    
  

  }

  edit(publication) {
    this.publicationService.setPublication(publication);
    console.log('Edit : ' + publication.title);
  }

  addPublication() {
    console.log("entrée dans addPublication");
  }
}
