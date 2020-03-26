import { Component, OnInit } from '@angular/core';
import { PublicationService } from '../publication.service';
import { Publication} from '../publication';
import { User } from '../user';
import { IsLoggedInService } from '../is-logged-in.service';



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
    private publicationService: PublicationService,
    private isLoggedInservice: IsLoggedInService
    ) { }
    

  ngOnInit() {
    
    this.publicationService.getPublications().subscribe(
      publications => {this.publicationList = publications.content;
        // let index=this.publicationList;
        console.log("XXXXXXXXXXXX");
        console.log(this.publicationList)
        this.isLoggedInservice.ngOnInit();
        this.isLoggedIn = this.isLoggedInservice.isLoggedIn 
        this.userLogin = this.isLoggedInservice.userLogin},
      err => console.log('Table not accessible')
    );
  }
  onSortUser(userCrit){
    
    let direction = "ASC";
    this.publicationService.getPublicationsSortedByCriteria(userCrit,direction).subscribe(
        publications => {this.publicationList = publications.content;
          this.isLoggedInservice.ngOnInit();
          this.isLoggedIn = this.isLoggedInservice.isLoggedIn 
          this.userLogin = this.isLoggedInservice.userLogin},
        err => console.log('KO on Sort')
        
    )
  }
    
  

  // edit(publication) {
  //   this.publicationService.setPublication(publication);
  //   console.log('Edit : ' + publication.title);
  // }

  // addPublication() {
  //   console.log("entrée dans addPublication");
  // }
}
