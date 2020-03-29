import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { PublicationService} from '../publication.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { IsLoggedInService } from '../is-logged-in.service';
import { LoginServiceService } from '../login-service.service';
import { Type } from '../type';
import { Style } from '../style';
import { Observable } from 'rxjs';
 
@Component({
  selector: 'app-publication-create',
  templateUrl: './publication-create.component.html',
  styleUrls: ['./publication-create.component.css']
})
export class PublicationCreateComponent implements OnInit {

  publicationForm : FormGroup;
  typeListObservable : Observable<Type[]>;
  styleListObservable : Observable<Style[]>;

  constructor(private formBuilder : FormBuilder,private publicationService : PublicationService,private router : Router, private isLoggedIn : IsLoggedInService,
    private loginservice: LoginServiceService) { }

  ngOnInit() {

      this.typeListObservable=this.publicationService.getTypes();
      this.styleListObservable=this.publicationService.getStyles();

      this.publicationForm=this.formBuilder.group({
      artistName : '',
      artworkName : '',
      artworkEditor : '',
      artworkProducer : '',
      titleName : '',
      titleType : '',
      titleStyle : '',
      titleAuthor : '',
      titleComposer : '',
      snippet : ''
    })
  }

  onNewPublication(form){

    this.isLoggedIn.ngOnInit();
    if (this.isLoggedIn.isLoggedIn) {

      // get connected user // if exist update publication with provided data from the form
      this.loginservice.checkUser(this.isLoggedIn.userLogin).subscribe (
      userRetrieved => {
        const user = userRetrieved;
        let artist= {id:null,name:form.artistName,publicationSet:null};
        if (form.artistName=='') {artist=null};
        let artwork={id:null,name:form.artworkName,editor:form.artworkEditor,producer:form.artworkProducer,publicationSet:null};
        if (form.artworkName=='') {artwork=null};
        let title={id:null,name:form.titleName,type:form.titleType,style:form.titleStyle,author:form.titleAuthor,composer:form.titleComposer,publications:null};
        if (form.titleName=='') {title=null};
        const date=new Date();
        const publication = {id:null,appUser:user,artist:artist,date:date,artwork:artwork,title:title,snippet:form.snippet};
        this.publicationService.postPublicationObservable(publication).subscribe(
          value => {
            this.router.navigate(['publications-list']);
          },
          (error : HttpErrorResponse) => {
            if (error.status==456) { alert ("Artist and/or Artwork and/or Title must be filled")};
            if (error.status==457) { alert ("Publication still existed")};
          }
        )
      }  
      )
    }
    err => console.log("User loginLocalStorage not existing in Backend");
  }

}
