import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { PublicationService} from '../publication.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { IsLoggedInService } from '../is-logged-in.service';
import { LoginServiceService } from '../login-service.service';
import { Publication } from '../publication';
import { HttpErrorResponse } from '@angular/common/http';
import { Type } from '../type';
import { Style } from '../style';
import { Observable } from 'rxjs';
import { Title } from '../title';

@Component({
  selector: 'app-publication-update',
  templateUrl: './publication-update.component.html',
  styleUrls: ['./publication-update.component.css']
})
export class PublicationUpdateComponent implements OnInit {

  publicationForm : FormGroup;
  publicationId;
  typeListObservable : Observable<Type[]>;
  styleListObservable : Observable<Style[]>;
  titleToEdit;

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
     //
     let artistToEditName;
     if (value.artist != null)
      { artistToEditName = value.artist.name}
      else 
      {artistToEditName = ''}
     //
     let artworkToEdit;
     if (value.artwork != null)
      { artworkToEdit = {id:null,name:value.artwork.name, editor: value.artwork.editor,producer:value.artwork.producer, publicationSet:null}}
      else 
      {artworkToEdit = {id:null,name:'', editor: '',producer:'', publicationSet:null}}
      // OU
     // var artworkToEditName : string
     // if (value.artwork != null) {artworkToEditName=value.artwork.name} else {artworkToEditName=''};
     //let titleToEdit;
     if (value.title != null)
      { this.titleToEdit = {id:null,name:value.title.name, type: value.title.type.type,style:value.title.style.style, author:value.title.author, composer:value.title.composer, publications:null};}
      else 
      {this.titleToEdit = {id:null,name:'', type: '',style:'', author:'', composer:'', publications:null}}
        console.log(this.titleToEdit.style);
      this.typeListObservable=this.publicationService.getTypes();
      this.styleListObservable=this.publicationService.getStyles();
     
      this.publicationForm=this.formBuilder.group({
      artistName : artistToEditName,
      artworkName : artworkToEdit.name,
      artworkEditor : artworkToEdit.editor,
      artworkProducer : artworkToEdit.producer,
      titleName : this.titleToEdit.name,
      titleStyle : this.titleToEdit.style,
      titleType : this.titleToEdit.type,
      titleAuthor : this.titleToEdit.author,
      titleComposer : this.titleToEdit.composer,
      snippet : value.snippet  
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
