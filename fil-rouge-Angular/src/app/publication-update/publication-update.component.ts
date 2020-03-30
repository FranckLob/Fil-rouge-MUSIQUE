import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { PublicationService} from '../publication.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { IsLoggedInService } from '../is-logged-in.service';
import { LoginServiceService } from '../login-service.service';
import { Publication } from '../publication';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-publication-update',
  templateUrl: './publication-update.component.html',
  styleUrls: ['./publication-update.component.css']
})
export class PublicationUpdateComponent implements OnInit {

  publicationForm : FormGroup;
  publicationId;

  constructor(private formBuilder : FormBuilder,
    private publicationService : PublicationService,
    private route: ActivatedRoute,
    private router : Router,
    private isLoggedIn : IsLoggedInService,
    private loginservice: LoginServiceService) { }
  

  ngOnInit() {

    this.route.paramMap.subscribe(params => {
      this.publicationId = params.get('publicationId');
      this.publicationService.getOnePublication(this.publicationId).subscribe(
      value => {  
      this.publicationForm=this.formBuilder.group({
      artistName : value.artist.name,
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
      })
    })
  }

  onPublicationUpdate(form){

    this.isLoggedIn.ngOnInit();

    if (this.isLoggedIn.isLoggedIn) {

      // get connected user // if exist update publication with provided data from the form
      this.loginservice.checkUser(this.isLoggedIn.userLogin).subscribe(
        userRetrieved => {
          const user = userRetrieved;
          const artist= {id:null,name:form.artistName,publicationSet:null};
          //const artwork = {id:null,name:form.artworkName, editor: form.artWorkEditor,producer:form.artworkProducer, publicationSet:null};
          //const title = {id:null,name:form.titleName, type: form.titleType,style:form.titleStyle, author:form.titleAuthor, 
          //  composer:form.titleComposer, publications:null};
          //const snippet = form.snippet;
          const date=new Date();
          let publication : Publication;
          //publication = {id:form.id,appUser:user,artist:artist,date:date,artwork:artwork,title:title,snippet:snippet};
          publication = {id:this.publicationId,appUser:user,artist:artist,date:date,artwork:null,title:null,snippet:null};
          this.publicationService.putPublicationObservable(publication).subscribe(value => {
          this.router.navigate(['publications-list']);
        },
        (error : HttpErrorResponse) => {
          if (error.status==456) { alert ("Artist and/or Artwork and/or Title must be filled")};
          if (error.status==457) { alert ("Publication still existed")};
        }
        )
        },
        err => console.log("User loginLocalStorage not existing in Backend")
      );       
    }
  }
  
}
