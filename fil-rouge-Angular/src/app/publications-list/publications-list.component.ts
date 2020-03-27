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
  userLogin:User;
  isLoggedIn : Boolean = false;
  ascendingSort : Boolean = true;

  constructor(
    private publicationService: PublicationService,
    private isLoggedInService: IsLoggedInService
    ) { }
    

  ngOnInit() {
    // Read user's Login if exists
    // let key = 'login';
    //  this.userLogin = JSON.parse(localStorage.getItem(key));
    
    this.publicationService.getPublications().subscribe(
      publications => {this.publicationList = publications.content;
        console.log("XXXXXXXXXXXX");
        console.log(this.publicationList)
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

  // edit(publication) {
  //   this.publicationService.setPublication(publication);
  //   console.log('Edit : ' + publication.title);
  // }

  // addPublication() {
  //   console.log("entrée dans addPublication");
  // }

  // sortPublication(criteria) {  //declanché sur onChange sur le select du critere de tri.
  //   console.log("criteria : "+criteria);
  //   console.log("this.sortForm : "+this.sortForm);
  //   // this.aliments.sort(this.alimentsService.tri); 
  //   this.publicationList = this.publicationService.publicationList.sort(this.alimentsService.tri);
  // }


}
