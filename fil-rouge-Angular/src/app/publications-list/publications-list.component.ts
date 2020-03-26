import { Component, OnInit } from '@angular/core';
import { PublicationService } from '../publication.service';
import { Publication} from '../publication';
import { User } from '../user';


@Component({
  selector: 'app-publications-list',
  templateUrl: './publications-list.component.html',
  styleUrls: ['./publications-list.component.css']
})
export class PublicationsListComponent implements OnInit {


  publicationList : Publication[];
  userLogin:String;
  isLoggedIn : Boolean = false;

  constructor(
    private publicationService: PublicationService
    ) { }
    

  ngOnInit() {
    
    this.publicationService.getPublications().subscribe(
      publications => {this.publicationList = publications.content;
        // let index=this.publicationList;
        console.log("XXXXXXXXXXXX");
        console.log(this.publicationList)},
      err => console.log('Table not accessible')
    );
  }

  // edit(publication) {
  //   this.publicationService.setPublication(publication);
  //   console.log('Edit : ' + publication.title);
  // }

  // addPublication() {
  //   console.log("entrée dans addPublication");
  // }
}
