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
  ascendingSort : Boolean = true;

  constructor(
    private publicationService: PublicationService,
    private isLoggedInService: IsLoggedInService
    private router : Router
    ) { }
    

  ngOnInit() {
    this.publicationService.getPublications().subscribe(
      publications => {this.publicationList = publications.content;
        this.isLoggedInService.ngOnInit();
        this.isLoggedIn = this.isLoggedInService.isLoggedIn 
        this.userLogin = this.isLoggedInService.userLogin},
      err => console.log('Table not accessible')
    );
  }

  sortOnUser(){
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }
    this.publicationService.getPublicationsSortedByCriteria("user",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on user')
    )
  }

  sortOnArtist(){
    
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }

    this.publicationService.getPublicationsSortedByCriteria("artist",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on artist')
    )
  }

  sortOnDate(){
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }
    this.publicationService.getPublicationsSortedByCriteria("date",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on date')
    )
  }

  sortOnArtwork(){
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }
    this.publicationService.getPublicationsSortedByCriteria("artwork",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on artwork')
    )
  }

  sortOnTitle(){
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }
    this.publicationService.getPublicationsSortedByCriteria("title",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on title')
    )
  }

  sortOnStyle(){
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }
    this.publicationService.getPublicationsSortedByCriteria("style",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on style')
    )
  }

  sortOnType(){
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }
    this.publicationService.getPublicationsSortedByCriteria("type",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on type')
    )
  }

  sortOnAuthor(){
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }
    this.publicationService.getPublicationsSortedByCriteria("author",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on author')
    )
  }

  sortOnComposer(){
    let direction;
    if(this.ascendingSort){
      direction = "ASC";
      this.ascendingSort = false;
    }
    else{
      direction="DESC";
      this.ascendingSort = true;
    }
    this.publicationService.getPublicationsSortedByCriteria("composer",direction).subscribe(
        publications => {this.publicationList = publications.content;
                         this.isLoggedInService.ngOnInit();
                         this.isLoggedIn = this.isLoggedInService.isLoggedIn 
                         this.userLogin = this.isLoggedInService.userLogin},
        err          => console.log('KO on Sort on composer')
    )
  }


  deletePublication(publicationToDelete : Publication){
      if (confirm ('Do you really want to delete this publication of' + publicationToDelete.appUser.nickName)) {
        this.publicationService.deletePublication(publicationToDelete.id).subscribe(
          status => {
          const index: number = this.publicationList.indexOf(publicationToDelete);
          this.publicationList.splice(index, 1)},
          err => console.log('KO' + err)
        );
      }
    }

  edit(publication) {
      this.router.navigate(['publication-update'], publication);   
   }


}
