import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { PublicationService} from '../publication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-publication-create',
  templateUrl: './publication-create.component.html',
  styleUrls: ['./publication-create.component.css']
})
export class PublicationCreateComponent implements OnInit {

  publicationForm : FormGroup;

  constructor(private formBuilder : FormBuilder,private publicationService : PublicationService,private router : Router) { }

  ngOnInit() {
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
    const userFranck={id:null,nickName:'Franck',email:'franck.lobjois.devweb@gmail.com',authority:null,publicationlist:null};
    const artist= {id:null,name:form.artistName,publicationSet:null};
    const date=new Date();
    const publication= {id:null,appUser:userFranck,artist:artist,date:date,artwork:null,title:null,snippet:null};
    this.publicationService.postPublicationObservable(publication).subscribe(value => {
      this.router.navigate(['']);
    }) 
  }

}
