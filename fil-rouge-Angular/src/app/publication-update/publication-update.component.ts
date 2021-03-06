import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { PublicationService} from '../publication.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { IsLoggedInService } from '../is-logged-in.service';
import { LoginServiceService } from '../login-service.service';
import { Publication } from '../publication';



@Component({
  selector: 'app-publication-update',
  templateUrl: './publication-update.component.html',
  styleUrls: ['./publication-update.component.css']
})
export class PublicationUpdateComponent implements OnInit {

  publicationForm : FormGroup;

  constructor(private formBuilder : FormBuilder,
    private publicationService : PublicationService,
    private route: ActivatedRoute,
    private router : Router,
    private isLoggedIn : IsLoggedInService,
    private loginservice: LoginServiceService) { }
  

  ngOnInit() {
   
    
      this.publicationForm=this.formBuilder.group({
      artistName : this.publicationForm.value.artistName,
      artworkName : this.publicationForm.value.artworkName,
      artworkEditor : this.publicationForm.value.artworkEditor,
      artworkProducer : this.publicationForm.value.artworkProducer,
      titleName : this.publicationForm.value.titleName,
      titleType : this.publicationForm.value.titleType,
      titleStyle : this.publicationForm.value.titleStyle,
      titleAuthor : this.publicationForm.value.titleAuthor,
      titleComposer : this.publicationForm.value.titleComposer,
      snippet : this.publicationForm.value.snippet
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
          const artwork = {id:null,name:form.artworkName, editor: form.artWorkEditor,producer:form.artworkProducer, publicationSet:null};
          const title = {id:null,name:form.titleName, type: form.titleType,style:form.titleStyle, author:form.titleAuthor, 
            composer:form.titleComposer, publications:null};
          const snippet = form.snippet;
          const date=new Date();
          let publication : Publication;
          publication = {id:form.id,appUser:user,artist:artist,date:date,artwork:artwork,title:title,snippet:snippet};

          this.publicationService.putPublicationObservable(publication).subscribe(value => {
          this.router.navigate(['publications-list']);
        })
        },
        err => console.log("User loginLocalStorage not existing in Backend")
      );       
    }
  }
  
}
