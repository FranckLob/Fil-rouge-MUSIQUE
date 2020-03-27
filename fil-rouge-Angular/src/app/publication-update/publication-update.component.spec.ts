import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicationUpdateComponent } from './publication-update.component';

describe('PublicationUpdateComponent', () => {
  let component: PublicationUpdateComponent;
  let fixture: ComponentFixture<PublicationUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicationUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicationUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
