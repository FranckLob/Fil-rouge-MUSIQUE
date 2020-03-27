import { Component, OnInit } from '@angular/core';
import { PublicationService } from '../publication.service';
import { Publication} from '../publication';
import { User } from '../user';
import { IsLoggedInService } from '../is-logged-in.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-publications-list',
  templateUrl: './publications-list.component.html',
  styleUrls: ['./publications-list.component.css']
})
export class PublicationsListComponent implements OnInit {


  publicationList : Publication[];
  userLogin:String;
  isLoggedIn : Boolean = false;
  publicationToFeedForm : Publication;

  constructor(
    private publicationService: PublicationService,
    private isLoggedInservice: IsLoggedInService,
    private router : Router
    ) { }
    

  ngOnInit() {
    
    this.publicationService.getPublications().subscribe(
      publications => {this.publicationList = publications.content;
        this.isLoggedInservice.ngOnInit();
        this.isLoggedIn = this.isLoggedInservice.isLoggedIn 
        this.userLogin = this.isLoggedInservice.userLogin},
      err => console.log('Publication Table not accessible')
    );
  }

  onSortUser(){
    
    let direction = "ASC";
    let criteria = "appUser";
    this.publicationService.getPublicationsSortedByCriteria(criteria,direction).subscribe(
        publications => {this.publicationList = publications.content;
          this.isLoggedInservice.ngOnInit();
          this.isLoggedIn = this.isLoggedInservice.isLoggedIn 
          this.userLogin = this.isLoggedInservice.userLogin},
        err => console.log('KO on Sort user')     
    )
  }
    
  edit(publication) {
      this.router.navigate(['publication-update'], publication);   
   }

}
