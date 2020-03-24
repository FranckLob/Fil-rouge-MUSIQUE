import { Component, OnInit } from '@angular/core';
import { PublicationService } from '../publication.service';


@Component({
  selector: 'app-publications-list',
  templateUrl: './publications-list.component.html',
  styleUrls: ['./publications-list.component.css']
})
export class PublicationsListComponent implements OnInit {

  publications;

  constructor(
    private publicationService: PublicationService
    ) { }

  ngOnInit() {
    this.publications = this.publicationService.getPublications();
  }

  edit(publication) {
    this.publicationService.setPublication(publication);
    console.log('Edit : ' + publication.title);
  }

  addPublication() {
    console.log("entrée dans addPublication");
  }
}
